package com.vaccinationApp.DTO;

import java.time.LocalDate;
import java.util.List;

import com.vaccinationApp.model.Member;

import lombok.Data;


@Data
public class VaccineRegistrationDTO {
	
	private long mobileNo;
	
	private LocalDate dateOfReg;
	
	private List<Member> members;
	
}
