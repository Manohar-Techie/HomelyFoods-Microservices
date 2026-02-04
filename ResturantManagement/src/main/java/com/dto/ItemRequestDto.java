package com.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemRequestDto {
private String itemName;
		
	private double price;
	
	private String itemType;
	
	private String category;
}
