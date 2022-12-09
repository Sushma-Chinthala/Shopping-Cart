package com.cg.orders.orderservice.OrderService.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cg.orders.orderservice.OrderService.exception.CustomerNotFoundException;
import com.cg.orders.orderservice.OrderService.exception.OrderNotFoundException;
import com.cg.orders.orderservice.OrderService.models.Address;
import com.cg.orders.orderservice.OrderService.models.Cart;
import com.cg.orders.orderservice.OrderService.models.Orders;
import com.cg.orders.orderservice.OrderService.repository.AddressRepository;
import com.cg.orders.orderservice.OrderService.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
	Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
	@Autowired
	OrderRepository orderRepository;
	@Autowired
	AddressRepository addressRepository;

	@Autowired
	private SequenseGeneratorService seqService;
	@Autowired
	RestTemplate restTemplate;

	@Override
	public List<Orders> getAllOrders() {
		return orderRepository.findAll();
	}

	@Override
	public void placeOrder(Cart cart, String mode, String fullName) {
		Orders order = new Orders();
		order.setOrderId(seqService.getSequenseNum(Orders.SEQUENSE_NAME));
		LocalDate today = LocalDate.now();
		order.setOrderDate(today);
		order.setAmountPaid(cart.getTotalPrice());
		
		order.setModeOfPayment(mode);
		order.setQuantity(cart.getItems().size());
		order.setOrderStatus("confirmed");
		Address address = addressRepository.findByFullName(fullName);
		order.setCustomerId(address.getCustomerId());
		order.setAddress(address);
		order.setFullName(fullName);
		orderRepository.save(order);
		logger.info(("order is placed with" + order.getOrderId()));
		restTemplate.delete("http://Cart-Services/cart/delete/" + cart.getCartId());

	}

	@Override
	public String  changeStatus(String orderStatus, int orderId) throws OrderNotFoundException 
	{
		Orders orders=orderRepository.findById(orderId).orElseThrow();
		orders.setOrderStatus(orderStatus);
		return orderStatus;
		/*
		 * if(orderRepository.existsById(orderId)) { //return
		 * orderRepository.save(orderStatus); Orders
		 * order=orderRepository.findById(orderId).
		 * 
		 * } return orderStatus; else { logger.error("ID NOT FOUND "+orderId); throw new
		 * OrderNotFoundException("ORDER NOT EXISTS WITH ID "+orderId); }
		 */
	}

	@Override
	public void deleteOrder(int orderId) {
		orderRepository.deleteById(orderId);

	}

	@Override
	public List<Orders> getOrderByCustomerId(int customerId) {
		if (orderRepository.existsById(customerId)) {
			return orderRepository.findByCustomerId(customerId);
		} else {
			logger.error("CUSTOMER NOT FOUND WITH ID");
			throw new CustomerNotFoundException("Customer Not Exists With ID " + customerId);
		}
	}

	@Override
	public void storeAddress(Address address) {
		address.setCustomerId(seqService.getSequenseNum(Address.SEQUENSE_NAME));
		addressRepository.save(address);
	}

	@Override
	public List<Address> getAddressByCustomerId(int customerId) {
		if (addressRepository.existsById(customerId)) {
			return addressRepository.findByCustomerId(customerId);
		} else {
			logger.error("CUSTOMER NOT FOUND WITH THE  ID " + customerId);
			throw new CustomerNotFoundException("Customer Not Found With Id " + customerId);
		}
	}

	@Override
	public List<Address> getAllAddress() {

		return addressRepository.findAll();
	}

	

	@Override
	public Optional<Orders> getOrderById(int orderId) {
		if (orderRepository.existsById(orderId))
		{
			return orderRepository.findById(orderId);
		} else {
			logger.error("ORDER NOT FOUND");
			throw new OrderNotFoundException("Order Not Found With Id " + orderId);
		}
	}

	
	
}
