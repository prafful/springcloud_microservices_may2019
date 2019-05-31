package com.springcloud.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springcloud.main.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
	
	ProductEntity findByProductCode(String productCode);
	
}
