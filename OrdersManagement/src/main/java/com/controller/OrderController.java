package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.OrderRequestDto;
import com.dto.OrderResponseDto;
import com.service.OrderService;




@RestController
@RequestMapping("/order")
@RefreshScope
public class OrderController {
	
	
	@Value("${discount.food}")
	private int discount;
	
	private final OrderService orderService;
	

	
	@Autowired
	public OrderController(OrderService orderService) {
		this.orderService=orderService;
		}
	
	//@PostMapping("/order")
	@PostMapping("/place")
	public ResponseEntity<OrderResponseDto> placeOrder(@RequestBody OrderRequestDto orderRequestDto){
		OrderResponseDto placeOrder = orderService.placeOrder(orderRequestDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(placeOrder);
		
	}
	
	@GetMapping("/discount")
	public int discount() {
		return discount;
	}

}
