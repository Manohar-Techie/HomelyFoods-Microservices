package com.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Orders {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long orderId;
	
	private long userId;
	
	private long restaurantId;
	

	
//	private String status;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="orderId")
	private List<OrderItems> orderItems;
	
	private double orderPrice;

	public Orders(long userId, long restaurantId,  List<OrderItems> orderItems, double orderPrice) {
		super();
		this.userId = userId;
		this.restaurantId = restaurantId;
	//	this.status = status;
		this.orderItems = orderItems;
		this.orderPrice = orderPrice;
	}
	
}
