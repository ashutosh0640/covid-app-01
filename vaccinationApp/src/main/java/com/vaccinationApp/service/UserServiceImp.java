package com.vaccinationApp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaccinationApp.exceptions.UserException;
import com.vaccinationApp.model.User;
import com.vaccinationApp.repository.UserRepository;


@Service
public class UserServiceImp implements UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public User registerUser(User user) {
		Optional<User> userr = userRepo.findById(user.getId());
		if(userr.isPresent()) {
			throw new UserException("This user is alread registered.");
		}
		User u = userRepo.save(user);
		return u;
	}

	@Override
	public User updateUser(User user) {
		User userr = userRepo.findById(user.getId()).orElseThrow(()->new UserException("This user is not found."));
		userr.setName(user.getName());
		userr.setDob(user.getDob());
		userr.setGender(user.getGender());
		userr.setAddress(user.getAddress());
		userr.setCity(user.getCity());
		userr.setState(user.getState());
		userr.setPincode(user.getPincode());
		userr.setPanNo(user.getPanNo());
		userr.setAadhar(user.getAadhar());
		userRepo.save(userr);
		return userr;
	}


	@Override
	public User  getUserByPanCard(String panNo) {
		User user = userRepo.getUserByPanNo(panNo);
		if(user == null) {
			throw new UserException("User is not found by this pan no: "+panNo);
		}
		return user;
	}

	@Override
	public User getUserByAdharCard(Long adharNo) {
		User user = userRepo.getUserByAdharNo(adharNo);
		if(user == null) {
			throw new UserException("User is not found by this aadhar no: "+adharNo);
		}
		return user;
	}

}
