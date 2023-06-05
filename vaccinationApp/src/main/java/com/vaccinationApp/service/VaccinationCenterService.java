package com.vaccinationApp.service;

import java.util.List;

import com.vaccinationApp.model.VaccinationCenter;

public interface VaccinationCenterService {
	
	public VaccinationCenter getVaccineCenter(int centerId);
	
	public VaccinationCenter addVaccineCenter(VaccinationCenter center);
	
	public VaccinationCenter upadateVaccineCenter(VaccinationCenter center);
	
	public boolean deleteVaccinationCenter(int code);
	
	public List<VaccinationCenter> getAllVaccinationCenter();
}
