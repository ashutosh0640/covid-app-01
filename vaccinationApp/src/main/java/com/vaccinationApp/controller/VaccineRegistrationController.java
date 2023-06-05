package com.vaccinationApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vaccinationApp.DTO.VaccineRegistrationDTO;
import com.vaccinationApp.model.Member;
import com.vaccinationApp.model.VaccineRegistration;
import com.vaccinationApp.service.VaccineRegistrationService;

import jakarta.validation.Valid;

@RestController
public class VaccineRegistrationController {
	
	@Autowired
	private VaccineRegistrationService vaccRegSer;
	
	
	@PostMapping("/vaccineregistration/")
	public ResponseEntity<VaccineRegistrationDTO> addVaccineRegistrationHandler( @RequestBody VaccineRegistration reg) {
		VaccineRegistrationDTO vaccReg = vaccRegSer.addVaccineRegistration(reg);
		return new ResponseEntity<>(vaccReg, HttpStatus.OK);
		
	}
	
	@GetMapping("/vaccineregistration/{id}")
	public ResponseEntity<VaccineRegistrationDTO> getVaccineRegistrationHandler(@Valid @PathVariable("id") Long mobileNo) {
		VaccineRegistrationDTO vaccReg= vaccRegSer.getVaccineRegistration(mobileNo);
		return new ResponseEntity<>(vaccReg, HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/vaccineregistrationmember/{id}")
	public ResponseEntity<List<Member>> getAllMemberHandler(@Valid @PathVariable("id") long mobileNo){
		List<Member> members  = vaccRegSer.getAllMember(mobileNo);
		return new ResponseEntity<>(members, HttpStatus.ACCEPTED);
	}
	
	
	@DeleteMapping("/vaccineregistration/{id}")
	public boolean deleteVaccineRegistrationHandler(@Valid @PathVariable("id") long mobileNo) {
		vaccRegSer.deleteVaccineRegistration(mobileNo);
		return true;
		
	}
	
	@GetMapping("/vaccineregistration/")
	public ResponseEntity<List<VaccineRegistration>> getAllVaccineRegistrationHandler() {
		List<VaccineRegistration> vaccRegs = vaccRegSer.getAllVaccineRegistration();
		return new ResponseEntity<>(vaccRegs, HttpStatus.OK);
	}
	
	@PutMapping("/vaccineregistration/")
	public ResponseEntity<VaccineRegistrationDTO> updateVaccineRegistrationHandler(VaccineRegistrationDTO reg) {
		VaccineRegistrationDTO vaccReg = vaccRegSer.updateVaccineRegistration(reg);
		return new ResponseEntity<>(vaccReg, HttpStatus.OK);
	}
}







