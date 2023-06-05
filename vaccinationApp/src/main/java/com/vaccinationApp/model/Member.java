package com.vaccinationApp.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Member {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int mem_id;
	
	@Column(columnDefinition = "boolean default false")
	private boolean dose1status;
	
	@Column(columnDefinition = "boolean default false")
	private boolean dose2status;
	
	private LocalDate dose1Date;
	
	private LocalDate dose2Date;
	
	@OneToOne(mappedBy="mem_id",cascade = CascadeType.ALL )
	private User user;
	
	@ManyToOne
	private VaccineRegistration mob_no;
	
	@OneToOne(mappedBy="mem_id", cascade = CascadeType.ALL)
	private Vaccine vaccineId;
	
	@OneToOne
	private Appointment booking_id;
	
}
