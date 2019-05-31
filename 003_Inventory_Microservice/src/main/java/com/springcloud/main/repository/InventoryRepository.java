package com.springcloud.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springcloud.main.entity.InventoryEntity;

public interface InventoryRepository extends JpaRepository<InventoryEntity, Long>{
		InventoryEntity findByProductCode(String productCode);
}
