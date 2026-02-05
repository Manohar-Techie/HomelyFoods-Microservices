package com.controller;

import java.util.Properties;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.RestaurantSavedResponseDto;
import com.dto.ResturantRequestDto;
import com.dto.ResturantResponseDto;
import com.model.Restaurant;
import com.service.RestaurantService;

@RestController
@RequestMapping("/restaurants")
public class ResturantController {
	

	@Autowired
	private final RestaurantService restaurantService;

	public ResturantController(RestaurantService restaurantService) {
		this.restaurantService = restaurantService;
	}

	@PostMapping("/add")
	public ResponseEntity<RestaurantSavedResponseDto> addResturant(
			@RequestBody ResturantRequestDto resturantRequestDto) {

		RestaurantSavedResponseDto savedResponseResponse = restaurantService.addRestaurant(resturantRequestDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedResponseResponse);

	}
    
	@GetMapping("/get/{restaurantId}")
	public ResponseEntity<ResturantResponseDto> getRestaurantDetails(@PathVariable (name="restaurantId") Long restaurantId) {
		
		ResturantResponseDto restaurantInfo = restaurantService.getRestaurantInfo(restaurantId);
		
		return ResponseEntity.ok(restaurantInfo);
		
	}
	
	@GetMapping("/getRestaurantName/{Id}")
	public ResponseEntity<String> getRestaurantName(@PathVariable (name="Id") Long restaurantId) {
		
		ResturantResponseDto restaurantInfo = restaurantService.getRestaurantInfo(restaurantId);
		
//		environment.getProperty("local.server.port");
		return ResponseEntity.ok(restaurantInfo.getResturantName());
		
	}
	
	
	
	
	
	
	
	
}
