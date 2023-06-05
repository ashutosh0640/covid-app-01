package com.vaccinationApp.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty
	private String name;
	
	@NotEmpty
	private LocalDate dob;
	
	@NotEmpty
	private String gender;
	
	@NotEmpty
	private String address;
	
	@NotEmpty
	private String city;
	
	@NotEmpty
	private String state ;
	
	@NotEmpty
	private String pincode;
	
	@NotEmpty
	private String panNo;
	
	@NotEmpty
	private long aadhar;
	
	@OneToOne
	@JsonIgnore
	private Member mem_id;
	
}
