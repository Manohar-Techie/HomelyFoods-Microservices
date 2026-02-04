package com.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemsResponseDto {
	private long orderItemId;

	private long itemId;

	private int quantity;
}
