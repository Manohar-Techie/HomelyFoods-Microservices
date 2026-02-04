package com.model;

import java.util.List;

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
@Data
@Table(name="user_address")
@AllArgsConstructor
@NoArgsConstructor
public class UserAddress {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long addressId;
	
	private String doorNumber;
	
	private String lanbMark;
	
	private String city;
	
	private String pincode;
	
	@ManyToOne
	@JoinColumn(name="user_id",nullable=false)
	private User user;

	public UserAddress(String doorNumber, String lanbMark, String city, String pincode, User user) {
		super();
		this.doorNumber = doorNumber;
		this.lanbMark = lanbMark;
		this.city = city;
		this.pincode = pincode;
		this.user = user;
	}
	
}
