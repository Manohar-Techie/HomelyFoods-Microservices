package com.builder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.dto.AddresRequestDto;
import com.dto.ItemRequestDto;
import com.dto.ResturantRequestDto;
import com.model.Address;
import com.model.Items;
import com.model.Restaurant;


public class  RestaurantBulider {

	public static Restaurant buildResturantFromRestaurantDto(ResturantRequestDto resturantRequestDto) {
		 Restaurant restaurant = Restaurant.builder()
			.restaurantName(resturantRequestDto.getResturantName())
			.phoneNumber(resturantRequestDto.getPhoneNumber())
			.address(buildAddressFromRestaurantDto(resturantRequestDto.getAddressRequestDto()))
			.build();
		 
		 List<Items> itemFromRestaurantDto = buildItemFromRestaurantDto(resturantRequestDto.getItemRequestDto(),restaurant);
		 restaurant.setItems(itemFromRestaurantDto);
		 return restaurant;
	}

	private static Address buildAddressFromRestaurantDto(AddresRequestDto addresRequestDto) {
		Address address=new Address();
		BeanUtils.copyProperties(addresRequestDto, address);
		return address;
	}
	
	private static List<Items> buildItemFromRestaurantDto(List<ItemRequestDto> itemRequestDto,Restaurant restaurant){
		List<Items> items=new ArrayList<>();
		for(ItemRequestDto item:itemRequestDto) {
			Items item1=new Items();
			BeanUtils.copyProperties(item, item1);
			item1.setRestaurant(restaurant);
			items.add(item1);
		}
		
		return items;
		
	}
	
}
