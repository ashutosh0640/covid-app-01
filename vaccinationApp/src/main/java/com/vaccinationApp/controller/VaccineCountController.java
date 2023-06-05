package com.vaccinationApp.controller;

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

import com.vaccinationApp.model.VaccineCount;
import com.vaccinationApp.service.VaccineCountServiceImp;

@RestController
public class VaccineCountController {
	
	
	@Autowired
	private VaccineCountServiceImp vcs;
	
	@PostMapping("/vaccineCount/")
	public ResponseEntity<VaccineCount> saveVaccineCountHandler(@RequestBody VaccineCount vaccineCount) {
		VaccineCount vc = vcs.saveVaccineCount(vaccineCount);
		return new ResponseEntity<>(vc, HttpStatus.OK);
	}
	
	@GetMapping("/vaccineCount/{id}")
	public ResponseEntity<VaccineCount> getVaccineCountByIdHandler(@PathVariable int id) {
		VaccineCount vc = vcs.getVaccineCountById(id);
		return new ResponseEntity<>(vc, HttpStatus.OK);
	}
	
	@PutMapping("/vaccineCount/")
	public ResponseEntity<VaccineCount>  updateVaccineCountHandler(@RequestBody VaccineCount vaccineCount) {
		VaccineCount vc = vcs.updateVaccineCount(vaccineCount);
		return new ResponseEntity<>(vc, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/vaccineCount/{id}")
	public ResponseEntity<String>  deleteVaccineCountHandler(@PathVariable int id) {
		vcs.deleteVaccineCount(id);
		return new ResponseEntity<>("delete successfully...", HttpStatus.OK);
	}
	
}
