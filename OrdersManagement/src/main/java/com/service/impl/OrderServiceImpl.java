package com.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.builder.OrderBuilder;
import com.builder.OrderDtoBuilder;
import com.clients.RestaurantClient;
import com.dao.OrderRepository;
import com.dto.OrderRequestDto;
import com.dto.OrderResponseDto;
import com.model.Orders;
import com.service.OrderService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;


@Service
public class OrderServiceImpl implements OrderService {
	
	private final OrderRepository orderRepository;
	
	private final RestTemplate restTemplate;
	
	@Autowired
	private RestaurantClient restaurantClient;
	
	public OrderServiceImpl(OrderRepository orderRepository, RestTemplate restTemplate){
		this.orderRepository=orderRepository;
		this.restTemplate=restTemplate;
	}

	
	@Override
	@CircuitBreaker(name = "restaurantService",fallbackMethod="restaurantFallBack")
	public OrderResponseDto placeOrder(OrderRequestDto orderRequestDto) {
		Orders orderFromOrderRequestDto = OrderBuilder.buildOrderFromOrderRequestDto(orderRequestDto);
	    Orders saveedOrder = orderRepository.save(orderFromOrderRequestDto);
	    OrderResponseDto orderDtoFromOrder = OrderDtoBuilder.buildOrderDtoFromOrder(saveedOrder);
	   // orderDtoFromOrder.setRestaurantName(fetchRestaurantNameById(orderRequestDto.getRestaurantId()));
	    
	    orderDtoFromOrder.setRestaurantName( restaurantClient.getRestaurantName(orderRequestDto.getRestaurantId()));
	    
		return orderDtoFromOrder;
	}
	
	
	
	public OrderResponseDto restaurantFallBack(OrderRequestDto orderRequestDto,Throwable throwable) {
		  return OrderResponseDto.builder()
	            .orderId(0L)
	            .restaurantName(null) // or ResponseEntity.ok("Unknown")
	            .status("restauranr service currently down")
	            .orderItems(List.of())
	            .orderPrice(0.0)
	            .build();
	}
	
	// this is for inter service communication having load balnce
	
//	public  String fetchRestaurantNameById(long restaurantId ) {
//		return	restTemplate.getForObject("http://ResturantManagement/resturants/getRestaurantName/"+restaurantId, String.class);
//	
//	
//	
//	}

}
