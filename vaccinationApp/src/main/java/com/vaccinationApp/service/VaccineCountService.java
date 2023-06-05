package com.vaccinationApp.service;

import com.vaccinationApp.model.VaccineCount;

public interface VaccineCountService {
	
	public VaccineCount saveVaccineCount(VaccineCount vaccineCount);
	
	public VaccineCount getVaccineCountById(int id);
	
	public VaccineCount updateVaccineCount(VaccineCount vc);
	
	public boolean deleteVaccineCount(int id);
	
	
	
}
