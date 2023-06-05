package com.vaccinationApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class VaccinationCenter {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int code;
	
	private String centerName;
	
	private String address;
	
	private String city;
	
	private String state;
	
	private String pincode;
	
	@ManyToOne
	private VaccineInventory inventory_id;
	
	@OneToOne
	private Appointment booking_id;
	
	
}
