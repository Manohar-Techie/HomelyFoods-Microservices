package com.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name="RestaurentManagement")
public interface RestaurantClient {
	@GetMapping("/restaurants/getRestaurantName/{Id}")
	public String getRestaurantName(@PathVariable (name="Id") Long restaurantId);

}
