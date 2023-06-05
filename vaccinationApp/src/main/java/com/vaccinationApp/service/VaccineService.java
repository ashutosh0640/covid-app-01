package com.vaccinationApp.service;

import java.util.List;

import com.vaccinationApp.model.Vaccine;

public interface VaccineService {
	
	public Vaccine getVaccineByName(String vName);
	
	public Vaccine getVaccineById(int vId);
	
	public Vaccine addVaccine(Vaccine vaccine);
	
	public Vaccine updateVaccine(Vaccine vaccine);
	
	public boolean deleteVaccine(int vaccineId);
	
	public List<Vaccine> getAllVaccine();
}
