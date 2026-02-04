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
@Table(name = "delivery_person")
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryPerson {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long deliveryPersonId;
	
	private String deliveryPersonName;
	
	private long deliveryPersonAdharNumber;
	
	private String deliveryPersonNumber;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="deliveryPerson")
	private List<DeliveryAssignments> deliveryAssignments;
	
	private boolean isAvailable;
	
	private double rating;

	public DeliveryPerson(String deliveryPersonName, long deliveryPersonAdharNumber, String deliveryPersonNumber,
			List<DeliveryAssignments> deliveryAssignments, boolean isAvailable, double rating) {
		super();
		this.deliveryPersonName = deliveryPersonName;
		this.deliveryPersonAdharNumber = deliveryPersonAdharNumber;
		this.deliveryPersonNumber = deliveryPersonNumber;
		this.deliveryAssignments = deliveryAssignments;
		this.isAvailable = isAvailable;
		this.rating = rating;
	}

	
}
