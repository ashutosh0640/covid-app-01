package com.vaccinationApp.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class VaccineCount {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int vCountId;
	
	private int quantity;
	
	private double price;
	
	@OneToOne
	private VaccineInventory inventory_id;
	
	@OneToOne(mappedBy="vCount_id", cascade = CascadeType.ALL)
	private Vaccine vaccine_id;
}
