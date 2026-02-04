package com.builder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.web.client.RestTemplate;

import com.dto.OrderItemsResponseDto;
import com.dto.OrderResponseDto;
import com.model.OrderItems;
import com.model.Orders;

public class OrderDtoBuilder {
	
	
	
	


	public static OrderResponseDto buildOrderDtoFromOrder(Orders orderFromOrderRequestDto ) {
		 OrderDtoBuilder orderDtoBuilder=new OrderDtoBuilder();
		 return OrderResponseDto.builder()
		.orderId(orderFromOrderRequestDto.getOrderId())
		.orderPrice(orderFromOrderRequestDto.getOrderPrice())
		.orderItems(OrderDtoBuilder.builderOrderItemsResponseDto(orderFromOrderRequestDto.getOrderItems()))
		.build();
	
		
	}
	
	
	private static List<OrderItemsResponseDto> builderOrderItemsResponseDto (List<OrderItems> orderItems) {
		List<OrderItemsResponseDto> itemsList=new ArrayList<>();
		for(OrderItems item:orderItems) {
			OrderItemsResponseDto orderItemsResponseDto=new OrderItemsResponseDto();
			BeanUtils.copyProperties(item, orderItemsResponseDto);
			itemsList.add(orderItemsResponseDto);
			
		}
		return itemsList;
		
	}
	
	

}
