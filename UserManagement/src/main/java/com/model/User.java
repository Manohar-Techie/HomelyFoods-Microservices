package com.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="user")
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long userId;
	private String userName;
	private String phoneNumber;
	private String email;
	private String password;
	
	
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL)
	private List<UserAddress> address;


	public User(String userName, String phoneNumber, String email, String password, List<UserAddress> address) {
		super();
		this.userName = userName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.password = password;
		this.address = address;
	}


}
