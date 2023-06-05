package com.vaccinationApp.service;

import java.time.LocalDate;
import java.util.List;

import com.vaccinationApp.model.Vaccine;
import com.vaccinationApp.model.VaccineInventory;

public interface VaccineInventoryService {
	
	public VaccineInventory addVaccineCount(VaccineInventory inv);
	
	public VaccineInventory getVaccineInventoryByCenterId(int center_Id);
	
	public VaccineInventory getVaccineInventoryById(int id);
	
	public VaccineInventory updateVaccineInventory(VaccineInventory inv);
	
	public boolean deleteVaccineInventory(int inventory_Id);
	
	public VaccineInventory getVaccineInventoryByDate(LocalDate date);
	
	public VaccineInventory getVaccineInventoryByVaccine(Vaccine vaccine);
	
	public List<VaccineInventory> getAllVaccineInventory();
	
}
