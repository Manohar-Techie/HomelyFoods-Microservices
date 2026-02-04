package com.model;

import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.CascadeType;
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
@Table(name = "delivery_assignments")
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryAssignments {
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long assignmentId;
	
	private long orderId;
	
	private LocalTime assignedTime;
	
	private String status;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="delivery_person_id",nullable=false)
	private DeliveryPerson deliveryPerson;

	public DeliveryAssignments(long orderId, LocalTime assignedTime, String status, DeliveryPerson deliveryPerson) {
		super();
		this.orderId = orderId;
		this.assignedTime = assignedTime;
		this.status = status;
		this.deliveryPerson = deliveryPerson;
	}
    
}
