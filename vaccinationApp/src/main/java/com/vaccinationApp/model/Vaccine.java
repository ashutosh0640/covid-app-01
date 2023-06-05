package com.vaccinationApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Vaccine {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int vaccineId;
	
	private String vaccineName;
	
	private String description;
	
	@OneToOne
	private Member mem_id;
	
	@OneToOne
	private VaccineCount vCount_id;
	
}
