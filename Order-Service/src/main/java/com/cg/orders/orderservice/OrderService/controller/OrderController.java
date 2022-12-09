package com.cg.orders.orderservice.OrderService.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

//import com.casestudy.productservice.entity.Product;
//import com.casestudy.productservice.entity.Product;
//import com.casestudy.productservice.entity.Product;
import com.cg.orders.orderservice.OrderService.models.Address;
import com.cg.orders.orderservice.OrderService.models.Cart;
import com.cg.orders.orderservice.OrderService.models.Orders;
import com.cg.orders.orderservice.OrderService.service.OrderService;
//import com.cg.orders.orderservice.OrderService.service.OrderServiceImpl;

@RestController
@RequestMapping("/orders")
public class OrderController
{
Logger logger=LoggerFactory.getLogger(OrderController.class);
@Autowired
OrderService orderService;

/*
 * public OrderController(OrderService orderService) { super();
 * this.orderService = orderService; }
 */

public OrderController() {
	super();
}
@GetMapping("/getalladdress")
public List<Address> getAllAddress()
{
	return orderService.getAllAddress();
}
@GetMapping("/getallorders")
public List<Orders> getAllOrders()
{
	return orderService.getAllOrders();
}
@GetMapping("/getorderbycustomerid/{customerId}")

public List<Orders> getOrderByCustomerId(@PathVariable int customerId) {
return orderService.getOrderByCustomerId(customerId);
	
}
@GetMapping("/getaddressbycustomerid/{customerId}")
public List<Address> getAddressByCustomerId(@PathVariable int customerId)
{
	return orderService.getAddressByCustomerId(customerId);
}
@GetMapping("/findmaxbyorderid/{orderId}")
public Optional<Orders> findByMaxByOrderId(@PathVariable int orderId)
{
	return orderService.getOrderById(orderId);
}
@PostMapping("/postorder/{mode}/{fullName}")
public void addOrder(@RequestBody Cart cart,@PathVariable String mode,@PathVariable String fullName)
{
	
	orderService.placeOrder(cart,mode,fullName);
	
}
@PostMapping("/addaddress")
public void storeAddress(@RequestBody Address address)
{
	orderService.storeAddress(address);
	
}
/*
 * @PutMapping("/changeorderstatus/{orderId}") public ResponseEntity<Orders>
 * changeOrderStatus(@PathVariable int orderId,@RequestBody Orders order) {
 * logger.warn("order"+order); Orders newstatus =
 * orderService.changeStatus(order, orderId); return new ResponseEntity<>
 * (newstatus,HttpStatus.CREATED);
 * 
 * }
 */
@PutMapping("/changeorderstatus/{orderId}") 
public void changeOrderStatus(@RequestBody String orderStatus,@PathVariable int orderId) {

orderService.changeStatus(orderStatus, orderId); 

}
@DeleteMapping("/deleteorder/{orderId}")
public ResponseEntity<String> deleteOrder(@PathVariable int orderId )
{
	orderService.deleteOrder(orderId);
	return ResponseEntity.ok("Your order is deleted with orderId "+orderId);
	
}

}
