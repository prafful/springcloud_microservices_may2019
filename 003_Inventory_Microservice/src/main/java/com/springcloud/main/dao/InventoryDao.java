package com.springcloud.main.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springcloud.main.entity.InventoryEntity;
import com.springcloud.main.repository.InventoryRepository;

@Repository("inventoryDao")
public class InventoryDao {
	
	@Autowired
	private InventoryRepository inventoryRepository;

	public List getAllInventory() {
		// TODO Auto-generated method stub
		return inventoryRepository.findAll();
	}

	public List addInventory(InventoryEntity ie) {
		// TODO Auto-generated method stub
		inventoryRepository.save(ie);
		return inventoryRepository.findAll();
	}

	public InventoryEntity getInventoryByProductCode(String productCode) {
		// TODO Auto-generated method stub
		return inventoryRepository.findByProductCode(productCode);
	}

}
