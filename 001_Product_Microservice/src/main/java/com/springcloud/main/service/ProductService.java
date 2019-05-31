package com.springcloud.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcloud.main.dao.ProductDao;
import com.springcloud.main.entity.ProductEntity;

@Service("productService")
public class ProductService {

	@Autowired
	private ProductDao productDao;
	
	public List getAllProducts() {
		// TODO Auto-generated method stub
		return productDao.getAllProducts();
	}

	public List addProduct(ProductEntity product) {
		// TODO Auto-generated method stub
		return productDao.addProduct(product);
	}

	public ProductEntity getProductByCode(String code) {
		// TODO Auto-generated method stub
		return productDao.getProductByCode(code);
	}

}
