package com.springcloud.main.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.main.entity.ProductEntity;
import com.springcloud.main.service.ProductService;

@RestController
@RefreshScope
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Value("${welcome.message}")
	private String message;
	

	@RequestMapping("/")
	public String welcome() {
		return message;
	}

	@RequestMapping("/all")
	public List getAllProducts() {
		return productService.getAllProducts();
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public List addProduct(@RequestBody ProductEntity product) {
		return productService.addProduct(product);
	}

	//http://localhost:9991/P002
	//http://localhost:9991/P001
	@RequestMapping("/{code}")   
	public ProductEntity getProductByCode(@PathVariable String code) {
		return productService.getProductByCode(code);
	}
}
