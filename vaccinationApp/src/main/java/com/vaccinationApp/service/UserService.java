package com.vaccinationApp.service;

import com.vaccinationApp.model.User;


public interface UserService {
	
	public User registerUser(User user);
	
	public User updateUser(User user);
	
	public User getUserByPanCard(String panNo);
	
	public User getUserByAdharCard(Long adharNo);
	
}
