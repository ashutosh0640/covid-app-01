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

import com.vaccinationApp.model.Appointment;
import com.vaccinationApp.service.AppointmentService;

@RestController
public class AppointmentController {
	
	@Autowired
	private AppointmentService appSer;
	
	@PostMapping("/appointment/")
	public ResponseEntity<Appointment> addAppointment(@RequestBody Appointment appointment) {
		Appointment app = appSer.addAppointment(appointment);
		return new ResponseEntity<>(app, HttpStatus.OK);
	}
	
	
	@GetMapping("/appointment/{id}")
	public  ResponseEntity<Appointment> getAppointmentHandler(@PathVariable("id") long bookingId) {
		Appointment app = appSer.getAppointment(bookingId);
		return new ResponseEntity<>(app, HttpStatus.OK);
	}

	

	@PutMapping("/appointment/")
	public ResponseEntity<Appointment> updateAppointment(@RequestBody Appointment appointment) {
		Appointment app = appSer.updateAppointment(appointment);
		return new ResponseEntity<>(app, HttpStatus.OK);
	}

	@DeleteMapping("/appointment/{id}")
	public ResponseEntity<String> deleteAppointment(@PathVariable long id) {
		appSer.deleteAppointment(id);
		return new ResponseEntity<>("Delete successfull..", HttpStatus.OK);
	}

	@GetMapping("/appointments/")
	public ResponseEntity<List<Appointment>> getAllAppointment() {
		List<Appointment> appointments = appSer.getAllAppointment();
		return new ResponseEntity<>(appointments, HttpStatus.OK);
	}
}
