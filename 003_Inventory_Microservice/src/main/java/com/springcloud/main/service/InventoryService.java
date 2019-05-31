package com.springcloud.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcloud.main.dao.InventoryDao;
import com.springcloud.main.entity.InventoryEntity;

@Service("inventoryService")
public class InventoryService {
	
	@Autowired
	private InventoryDao inventoryDao;

	public List getAllInventory() {
		// TODO Auto-generated method stub
		return inventoryDao.getAllInventory();
	}

	public List addInventory(InventoryEntity ie) {
		// TODO Auto-generated method stub
		return inventoryDao.addInventory(ie);
	}

	public InventoryEntity getInventoryByProductCode(String productCode) {
		// TODO Auto-generated method stub
		return inventoryDao.getInventoryByProductCode(productCode);
	}

}
