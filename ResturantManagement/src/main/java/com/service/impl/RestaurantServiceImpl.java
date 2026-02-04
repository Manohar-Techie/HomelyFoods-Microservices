package com.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.builder.RestaurantBulider;
import com.builder.RestaurantDtoBuilder;
import com.dto.RestaurantSavedResponseDto;
import com.dto.ResturantRequestDto;
import com.dto.ResturantResponseDto;
import com.model.Restaurant;
import com.service.RestaurantService;
import com.service.dao.RestaurantRepository;
import com.service.exception.IdNotFoundException;

@Service
public class RestaurantServiceImpl implements RestaurantService {


private final RestaurantRepository restaurantRepository;

public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
	this.restaurantRepository=restaurantRepository;
}

	@Override
	public RestaurantSavedResponseDto addRestaurant(ResturantRequestDto resturantRequestDto) {
		Restaurant restaurant = RestaurantBulider.buildResturantFromRestaurantDto(resturantRequestDto);
		Restaurant savedRestaurant = restaurantRepository.save(restaurant);
		return new RestaurantSavedResponseDto(savedRestaurant.getId(),savedRestaurant.getRestaurantName());
	}

	@Override
	public ResturantResponseDto getRestaurantInfo(Long restaurantId) {
		Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(()-> new IdNotFoundException("no id found"));
		return RestaurantDtoBuilder.buildRestaurantDtoFromRestaurant(restaurant);
		 
	}

}
