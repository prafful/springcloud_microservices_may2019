package com.springcloud.main.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springcloud.main.entity.ProductEntity;
import com.springcloud.main.repository.ProductRepository;

@Repository("productDao")
public class ProductDao {
	
	@Autowired
	private ProductRepository productRepository;

	public List getAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	public List addProduct(ProductEntity product) {
		// TODO Auto-generated method stub
		 productRepository.save(product);
		 return productRepository.findAll();
	}

}
