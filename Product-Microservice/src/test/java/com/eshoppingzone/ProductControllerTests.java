package com.eshoppingzone;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.casestudy.productservice.entity.Product;
import com.casestudy.productservice.repository.ProductRepository;
import com.casestudy.productservice.service.ProductService;

public class ProductControllerTests 
{
@Autowired
ProductService productService;
@MockBean
ProductRepository productRepository;

@Test
public void getAllProductsTest()
{
	
	  when(productRepository.findAll()).thenReturn(Stream.of(new Product(1,"Mobile","realme","samrt phones",4.5,"good","hjgyf",20000.0,"ghyd", "hfhj"))
	 .collect(Collectors.toList()));
	  assertEquals(1,productService.getAllProducts().size());
}
}
