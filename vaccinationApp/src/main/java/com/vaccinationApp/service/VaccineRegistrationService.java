package com.vaccinationApp.service;

import java.util.List;

import com.vaccinationApp.DTO.VaccineRegistrationDTO;
import com.vaccinationApp.model.Member;
import com.vaccinationApp.model.VaccineRegistration;

public interface VaccineRegistrationService {
	
	public VaccineRegistrationDTO getVaccineRegistration(Long mobileNo);
	
	public List<Member> getAllMember(Long mobileNo);
	
	public VaccineRegistrationDTO addVaccineRegistration(VaccineRegistration reg);

	
	public boolean deleteVaccineRegistration(long mobileNo);
	
	public List<VaccineRegistration> getAllVaccineRegistration();

	public VaccineRegistrationDTO updateVaccineRegistration(VaccineRegistrationDTO reg);
}
