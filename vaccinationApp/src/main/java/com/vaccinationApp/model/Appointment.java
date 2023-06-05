package com.vaccinationApp.model;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;

import java.lang.Enum;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Appointment {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long bookingId;
	
	private long mobileNo;
	
	private LocalDate dateOfBooking;
	
	@Enumerated
	private Slot slot;
	
	private boolean bookingStatus;
	
	
	@OneToOne(mappedBy="booking_id", cascade = CascadeType.ALL)
	private Member mem_id;
	
	@OneToOne(mappedBy="booking_id", cascade = CascadeType.ALL)
	private VaccinationCenter center_code;
	
}
