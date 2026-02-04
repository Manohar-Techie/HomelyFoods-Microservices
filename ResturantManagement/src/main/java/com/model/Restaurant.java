package com.model;

import java.util.List;

import com.dto.AddresResponseDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="restaurant")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Restaurant {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String restaurantName;
	
	private String phoneNumber;
	
	private double rating;
	
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="address_id")
	private Address address;
	
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy = "restaurant")
	private List<Items> items;


	public Restaurant(String restaurantName, String phoneNumber, double rating, Address address, List<Items> items) {
		super();
		this.restaurantName = restaurantName;
		this.phoneNumber = phoneNumber;
		this.rating = rating;
		this.address = address;
		this.items = items;
	}
	

}
