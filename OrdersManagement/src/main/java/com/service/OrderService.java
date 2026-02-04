package com.service;

import com.dto.OrderRequestDto;
import com.dto.OrderResponseDto;

public interface OrderService {
	
	OrderResponseDto placeOrder(OrderRequestDto orderRequestDto);

}
