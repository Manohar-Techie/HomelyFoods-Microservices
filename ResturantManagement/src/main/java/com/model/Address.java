package com.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "address")
@AllArgsConstructor
@NoArgsConstructor
public class Address {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long addressId;
	
	private String lanbMark;
	
	private String city;
	
	private String pincode;

	public Address(String lanbMark, String city, String pincode) {
		super();
		this.lanbMark = lanbMark;
		this.city = city;
		this.pincode = pincode;
	}

}
