package com.springcloud.main.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.springcloud.main.entity.InventoryResponse;
import com.springcloud.main.entity.ProductEntity;
import com.springcloud.main.repository.ProductRepository;

import reactor.core.publisher.Mono;

@Repository("productDao")
public class ProductDao {
	
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	
	
	
	public List getAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	public List addProduct(ProductEntity product) {
		// TODO Auto-generated method stub
		 productRepository.save(product);
		 return productRepository.findAll();
	}

	@HystrixCommand(fallbackMethod = "getProductByCodeFallBack", 
		commandProperties = {
		@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
	})
	public ProductEntity getProductByCode(String code) {
		/*
		 * try { Thread.sleep(3500); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		// TODO Auto-generated method stub
		ProductEntity tempProduct = productRepository.findByProductCode(code);
		System.out.println("Temporary Product: " + tempProduct.toString());
		//http://localhost:8080/shop/inventory/P001
		String url = "http://localhost:8080/shop/inventory/"+code ;
		//String url = "http://inventory-microservice/shop/inventory/"+code ;
		//ResponseEntity<InventoryResponse> inventoryResponse=restTemplate.getForEntity(url, InventoryResponse.class );

		InventoryResponse inventoryResponse
				= webClientBuilder
					.build()
					.get()
					.uri(url)
					.retrieve()
					.bodyToMono(InventoryResponse.class)
					.block();
		
		
		System.out.println("Response received from inventory micro service");
		System.out.println(inventoryResponse.toString());
		/*
		 * if(inventoryResponse.getStatusCode() == HttpStatus.OK) {
		 * if(inventoryResponse.getBody().getQuantity() > 0) {
		 * tempProduct.setStockStatus(true); productRepository.save(tempProduct); }else
		 * { tempProduct.setStockStatus(false); productRepository.save(tempProduct); }
		 */
		
		return tempProduct;
	}
	
	
	public ProductEntity getProductByCodeFallBack(String code) {
		System.out.println("#############Fallback called#######################");
		return null;
	}
	

}
