package com.springcloud.main.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.main.entity.ProductEntity;
import com.springcloud.main.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/")
	public String welcome() {
		return "Welcome to product microservice!";
	}

	@RequestMapping("/all")
	public List getAllProducts() {
		return productService.getAllProducts();
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public List addProduct(@RequestBody ProductEntity product) {
		return productService.addProduct(product);
	}
	
	
}
