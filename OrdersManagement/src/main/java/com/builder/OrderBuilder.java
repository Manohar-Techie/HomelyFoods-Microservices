package com.builder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.dto.OrderItemsRequestDto;
import com.dto.OrderRequestDto;
import com.model.OrderItems;
import com.model.Orders;

import jakarta.persistence.criteria.Order;

public class OrderBuilder {

	
	public static Orders buildOrderFromOrderRequestDto(OrderRequestDto orderRequestDto) {
		return 	Orders.builder()
				.restaurantId(orderRequestDto.getRestaurantId())
		.userId(orderRequestDto.getUserId())
		.orderPrice(orderRequestDto.getOrderPrice())
		.orderItems(OrderBuilder.builOrderItemfromOrderRequestDto(orderRequestDto.getOrderItems())).build();
		
		
	}
	
	private static List<OrderItems> builOrderItemfromOrderRequestDto(List<OrderItemsRequestDto> orderItems){
		List<OrderItems> orderItem = new ArrayList<>();
		for(OrderItemsRequestDto items:orderItems) {
			OrderItems orderItemsRequestDto=new OrderItems();
			BeanUtils.copyProperties(items, orderItemsRequestDto);
			orderItem.add(orderItemsRequestDto);
		}
		return orderItem;
		
	}
}
