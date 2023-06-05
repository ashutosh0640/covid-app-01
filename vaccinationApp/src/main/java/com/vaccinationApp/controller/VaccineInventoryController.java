package com.vaccinationApp.controller;

import java.time.LocalDate;
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
import com.vaccinationApp.model.VaccineInventory;
import com.vaccinationApp.service.VaccineInventoryServiceImp;


@RestController
public class VaccineInventoryController {
	
	
	@Autowired
	private VaccineInventoryServiceImp vis;
	
	
	@PostMapping("/vaccineInventory/")
	public ResponseEntity<VaccineInventory> addVaccineCountHandler(@RequestBody VaccineInventory inv) {
		VaccineInventory visSaved = vis.addVaccineCount(inv);
		return new ResponseEntity<>(visSaved, HttpStatus.OK);
	}
	
	@GetMapping("/vaccineInventory/{centerId}")
	public ResponseEntity<VaccineInventory> getVaccineInventoryByCenterIdHandler(@PathVariable("centerId") int center_Id) {
		VaccineInventory visSaved = vis.getVaccineInventoryByCenterId(center_Id);
		return new ResponseEntity<>(visSaved, HttpStatus.OK);
	}
	
	@GetMapping("/vaccineInventory/{id}")
	public ResponseEntity<VaccineInventory> getVaccineInventoryByIdHandler(@PathVariable int id) {
		VaccineInventory visSaved = vis.getVaccineInventoryById(id);
		return new ResponseEntity<>(visSaved, HttpStatus.OK);
	}
	
	@PutMapping("/vaccineInventory/")
	public ResponseEntity<VaccineInventory> updateVaccineInventoryHandler(@RequestBody VaccineInventory inv) {
		VaccineInventory visSaved = vis.updateVaccineInventory(inv);
		return new ResponseEntity<>(visSaved, HttpStatus.OK);
	}
	
	@DeleteMapping("/vaccineInventory/{id}")
	public ResponseEntity<String> deleteVaccineInventoryHandler(@PathVariable("id") int inventory_Id) {
		vis.deleteVaccineInventory(inventory_Id);
		return new ResponseEntity<>("Delete successful", HttpStatus.OK);
	}
	
	@GetMapping("/vaccineInventory/{date}")
	public ResponseEntity<VaccineInventory> getVaccineInventoryByDateHandler(@PathVariable LocalDate date) {
		VaccineInventory visSaved = vis.getVaccineInventoryByDate(date);
		return new ResponseEntity<>(visSaved, HttpStatus.OK);
	}
	
	@GetMapping("/vaccineInventory/{vaccine}")
	public ResponseEntity<VaccineInventory> getVaccineInventoryByVaccineHandler(Vaccine vaccine) {
		
		return null;
	}
	
	@GetMapping("/vaccineInventories/")
	public ResponseEntity<List<VaccineInventory>> getAllVaccineInventoryHandler() {
		List<VaccineInventory> viss = vis.getAllVaccineInventory();
		return new ResponseEntity<>(viss, HttpStatus.OK); 
	}
}
