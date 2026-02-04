package com.service;

import com.dto.RestaurantSavedResponseDto;
import com.dto.ResturantRequestDto;
import com.dto.ResturantResponseDto;
import com.model.Restaurant;

public interface RestaurantService {

	
	RestaurantSavedResponseDto addRestaurant(ResturantRequestDto resturantRequestDto);

	ResturantResponseDto getRestaurantInfo(Long restaurantId);
}
