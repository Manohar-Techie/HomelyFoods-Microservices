package com.builder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.dto.AddresRequestDto;
import com.dto.AddresResponseDto;
import com.dto.ItemRequestDto;
import com.dto.ItemResponseDto;
import com.dto.ResturantResponseDto;
import com.dto.ResturantResponseDto.ResturantResponseDtoBuilder;
import com.model.Address;
import com.model.Items;
import com.model.Restaurant;

public class RestaurantDtoBuilder {
	
	
	public static ResturantResponseDto buildRestaurantDtoFromRestaurant(Restaurant restaurant) {
		return  ResturantResponseDto.builder()
				.resturantName(restaurant.getRestaurantName())
				.addresResponseDto(buildAddresResponseDtofromRestaurant(restaurant.getAddress()))
				.phoneNumber(restaurant.getPhoneNumber())
				.itemResponseDto(buildItemResponseDto(restaurant.getItems())).build();
		
	}
	
	private static AddresResponseDto buildAddresResponseDtofromRestaurant(Address address) {
		AddresResponseDto addresResponseDto=new AddresResponseDto();
		BeanUtils.copyProperties(address, addresResponseDto);
		
		return addresResponseDto;
		
	}
	
	private static List<ItemResponseDto> buildItemResponseDto(List<Items> item){
		List<ItemResponseDto> itemResponse=new ArrayList<>();
		for(Items items: item) {
		ItemResponseDto itemResponseDto=new ItemResponseDto();
			BeanUtils.copyProperties(items, itemResponseDto);
			itemResponse.add(itemResponseDto);
		}
		
		return itemResponse;
		
	}

}
