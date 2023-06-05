package com.vaccinationApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaccinationApp.model.VaccinationCenter;
import com.vaccinationApp.repository.VaccinationCenterRepository;


@Service
public class VaccinationCenterServiceImp implements VaccinationCenterService {
	
	@Autowired
	private VaccinationCenterRepository vaccinationCentRepo;
	
	@Override
	public VaccinationCenter getVaccineCenter(int centerId) {
		VaccinationCenter vaccCent = vaccinationCentRepo.findById(centerId).orElseThrow();
		return vaccCent;
	}

	@Override
	public VaccinationCenter addVaccineCenter(VaccinationCenter center) {
		Optional<VaccinationCenter> vaccCent = vaccinationCentRepo.findById(center.getCode());
		if(vaccCent.isPresent()) {
			//throw
		}
		VaccinationCenter vaccCenter = vaccinationCentRepo.save(center);
		return vaccCenter;
	}

	@Override
	public VaccinationCenter upadateVaccineCenter(VaccinationCenter center) {
		VaccinationCenter vaccCent = vaccinationCentRepo.findById(center.getCode()).orElseThrow();
		vaccCent.setCenterName(center.getCenterName());
		vaccCent.setAddress(center.getAddress());
		vaccCent.setCity(center.getCity());
		vaccCent.setState(center.getState());
		vaccCent.setPincode(center.getPincode());
		vaccCent.setBooking_id(center.getBooking_id());
		vaccCent.setInventory_id(center.getInventory_id());
		
		vaccinationCentRepo.save(vaccCent);
		
		return vaccCent;
	}

	@Override
	public boolean deleteVaccinationCenter(int code) {
		VaccinationCenter vaccCent = vaccinationCentRepo.findById(code).orElseThrow();
		vaccinationCentRepo.delete(vaccCent);
		return true;
	}

	
	
	@Override
	public List<VaccinationCenter> getAllVaccinationCenter() {
		List<VaccinationCenter> centers =  vaccinationCentRepo.findAll();
		return centers;
	}

}
