package com.dto;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.model.OrderItems;
import com.model.Orders;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponseDto {
	private long orderId;
		
	private String restaurantName;
	
	private String status;
	
	private List<OrderItemsResponseDto> orderItems;
	
	private double orderPrice;
}
