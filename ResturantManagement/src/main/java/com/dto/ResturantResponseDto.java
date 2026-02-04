package com.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResturantResponseDto {
	private String resturantName;
	
	private String phoneNumber;
	
	private AddresResponseDto addresResponseDto;
	
	private List<ItemResponseDto> itemResponseDto;

}
