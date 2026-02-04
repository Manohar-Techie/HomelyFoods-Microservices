package com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orders_items")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItems {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderItemId;

	private long itemId;

	private int quantity;
	
	public OrderItems(long itemId, int quantity) {
		super();
		this.itemId = itemId;
		this.quantity = quantity;
	}

}
