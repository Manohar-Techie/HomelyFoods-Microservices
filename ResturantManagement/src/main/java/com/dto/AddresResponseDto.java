package com.dto;

import com.model.Items;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddresResponseDto {
private String lanbMark;
	
	private String city;
	
	private String pincode;
}
