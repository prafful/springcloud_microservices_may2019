package com.springcloud.main.entity;

import lombok.Data;

@Data
public class InventoryResponse {
	
	private String productCode;
	private Integer quantity;

}
