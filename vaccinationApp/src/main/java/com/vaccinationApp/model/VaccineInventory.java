package com.vaccinationApp.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;


@Data
@Entity
public class VaccineInventory {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int inventory_id;
	
	private LocalDate date;
	
	@OneToMany(mappedBy="inventory_id", cascade = CascadeType.ALL)
	private List<VaccinationCenter> center_code  = new ArrayList<>();
	
	@OneToOne(mappedBy="inventory_id", cascade = CascadeType.ALL)
	private VaccineCount vCount_id;
	
}
