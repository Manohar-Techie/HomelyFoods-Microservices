package com.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResturantRequestDto {
	private String resturantName;
	
	private String phoneNumber;
	
	private AddresRequestDto addressRequestDto;
	
	private List<ItemRequestDto> itemRequestDto;

}
