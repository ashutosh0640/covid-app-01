package com.vaccinationApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vaccinationApp.model.User;
import com.vaccinationApp.service.UserService;

@RestController
public class UserController {
	
	
	@Autowired
	private UserService userSer;
	
	
	@PostMapping("/user/")
	public ResponseEntity<User> registerUserHandler(@RequestBody User user) {
		User u = userSer.registerUser(user);
		return new ResponseEntity<>(u, HttpStatus.OK);
		
	}
	
	
	@PutMapping("/user/")
	public ResponseEntity<User> updateUser(@RequestBody User user){
		User u = userSer.updateUser(user);
		return new ResponseEntity<>(u, HttpStatus.OK);
	}
	
	
	@GetMapping("/user/{pan}")
	public ResponseEntity<User> getPanCardByNo(@PathVariable("pan") String panNo){
		User u = userSer.getUserByPanCard(panNo);
		return new ResponseEntity<>(u, HttpStatus.OK);
	}
	
	@GetMapping("/user/{adhar}")
	public ResponseEntity<User> getAdharCardByNo(@PathVariable("adhar") long adharNo){
		User u = userSer.getUserByAdharCard(adharNo);
		return new ResponseEntity<>(u, HttpStatus.OK);
	}
}
