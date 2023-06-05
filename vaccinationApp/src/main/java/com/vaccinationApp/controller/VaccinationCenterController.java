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

import com.vaccinationApp.model.VaccinationCenter;
import com.vaccinationApp.service.VaccinationCenterServiceImp;

@RestController
public class VaccinationCenterController {
	
	@Autowired
	private VaccinationCenterServiceImp vcs;
	
	@PostMapping("/vaccineCenter/")
	public ResponseEntity<VaccinationCenter> addVaccineCenterHandler(@RequestBody VaccinationCenter center) {
		VaccinationCenter vc = vcs.addVaccineCenter(center);
		return new ResponseEntity<>(vc, HttpStatus.OK);
	}
	
	
	@GetMapping("/vaccineCenter/{id}")
	public ResponseEntity<VaccinationCenter> getVaccineCenterHandler(@PathVariable("id") int centerId) {
		VaccinationCenter vc = vcs.getVaccineCenter(centerId);
		return new ResponseEntity<>(vc, HttpStatus.OK);
	}
	
	
	
	
	@PutMapping("/vaccineCenter/")
	public ResponseEntity<VaccinationCenter> upadateVaccineCenterHandler(@RequestBody VaccinationCenter center) {
		VaccinationCenter vc = vcs.upadateVaccineCenter(center);
		return new ResponseEntity<>(vc, HttpStatus.OK);      
	}
	
	@DeleteMapping("/vaccineCenter/{id}")
	public ResponseEntity<String> deleteVaccinationCenterHandler(@PathVariable("id") int code) {
		vcs.deleteVaccinationCenter(code);
		return new ResponseEntity<>("delete successful...", HttpStatus.OK);
	}
	
	
	@GetMapping("/vaccineCenters/")
	public ResponseEntity<List<VaccinationCenter>> getAllVaccinationCenterHandler() {
		List<VaccinationCenter> vc = vcs.getAllVaccinationCenter();
		return new ResponseEntity<>(vc, HttpStatus.OK);
	}

}
