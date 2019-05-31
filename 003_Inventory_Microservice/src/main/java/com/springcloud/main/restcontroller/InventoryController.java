package com.springcloud.main.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.main.entity.InventoryEntity;
import com.springcloud.main.service.InventoryService;

@RestController
public class InventoryController {
	
	@Autowired
	private InventoryService inventoryService;
	
	@RequestMapping("/")
	public String welcome() {
		return "Hello from Inventory Microservice!!!!";
	}
	
	@RequestMapping("/all")
	public List getAllInventory() {
		return inventoryService.getAllInventory();
	}
	
	@PostMapping("/add")
	public List addInventory(@RequestBody InventoryEntity ie) {
		return inventoryService.addInventory(ie);
	}
	
	
	  @GetMapping("/{code}")	
	  public InventoryEntity getInventoryByProductCode(@PathVariable("code") String productCode) {
		  return inventoryService.getInventoryByProductCode(productCode);
	  }
	 

}
