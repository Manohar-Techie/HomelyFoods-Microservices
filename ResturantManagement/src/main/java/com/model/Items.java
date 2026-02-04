package com.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@Table(name="items")
@AllArgsConstructor
@NoArgsConstructor
public class Items {
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	private long itemsId;
	
	private String itemName;
	
	private double rating;
	
	private double price;
	
	private boolean isAvailable;
	
	private String itemType;
	
	private String category;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

	public Items(String itemName, double rating, double price, boolean isAvailable, String itemType, String category,
			Restaurant restaurant) {
		super();
		this.itemName = itemName;
		this.rating = rating;
		this.price = price;
		this.isAvailable = isAvailable;
		this.itemType = itemType;
		this.category = category;
		this.restaurant = restaurant;
	}
    

	
}
