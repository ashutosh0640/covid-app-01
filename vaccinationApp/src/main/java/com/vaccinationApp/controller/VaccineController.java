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

import com.vaccinationApp.model.Vaccine;
import com.vaccinationApp.service.VaccineService;

@RestController
public class VaccineController {
	
	@Autowired
	private VaccineService vs;
	
	
	@PostMapping("/vaccine/")
	public ResponseEntity<Vaccine> addVaccineHandler(@RequestBody Vaccine vaccine) {
		Vaccine v = vs.addVaccine(vaccine);
		return new ResponseEntity<>(v, HttpStatus.OK);
	}
	
	
	@GetMapping("/vaccine/{name}")
	public ResponseEntity<Vaccine> getVaccineByNameHandler(@PathVariable("name") String vName) {
		Vaccine v  = vs.getVaccineByName(vName);
		return new ResponseEntity<>(v, HttpStatus.OK);
	}
	
	@GetMapping("/vaccine/{id}")
	public  ResponseEntity<Vaccine> getVaccineByIdHandler(@PathVariable("id") int vId) {
		Vaccine v = vs.getVaccineById(vId);
		return new ResponseEntity<>(v, HttpStatus.OK);
	}
	
	@PutMapping("/vaccine/")
	public ResponseEntity<Vaccine> updateVaccineHandle(Vaccine vaccine){
		Vaccine v = vs.updateVaccine(vaccine);
		return new ResponseEntity<>(v, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/vaccine/")
	public ResponseEntity<String> deleteVaccineHandler(int vaccineId) {
		vs.deleteVaccine(vaccineId);
		return new ResponseEntity<>("delete Successfull", HttpStatus.OK);
	}
	
	
	@GetMapping("/vaccines/")
	public ResponseEntity<List<Vaccine>> getAllVaccine() {
		List<Vaccine> v = vs.getAllVaccine();
		return new ResponseEntity<>(v, HttpStatus.OK);
	}
}
