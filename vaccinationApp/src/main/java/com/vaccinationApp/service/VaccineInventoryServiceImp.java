package com.vaccinationApp.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaccinationApp.model.Vaccine;
import com.vaccinationApp.model.VaccineInventory;
import com.vaccinationApp.repository.VaccineInventoryRepository;


@Service
public class VaccineInventoryServiceImp implements VaccineInventoryService {
	
	@Autowired
	private VaccineInventoryRepository vaccineInvRepo;
	
	@Override
	public VaccineInventory addVaccineCount(VaccineInventory inv) {
		VaccineInventory vi = vaccineInvRepo.save(inv);
		return vi;
	}
	
	@Override
	public VaccineInventory getVaccineInventoryByCenterId(int center_id) {
		VaccineInventory vi = vaccineInvRepo.findById(center_id).orElseThrow();
		return vi;
	}

	

	@Override
	public VaccineInventory updateVaccineInventory(VaccineInventory inv) {
		VaccineInventory vi = vaccineInvRepo.findById(inv.getInventory_id()).orElseThrow();
		vi.setDate(inv.getDate());
		vi.setCenter_code(inv.getCenter_code());
		vi.setVCount_id(inv.getVCount_id());
		vaccineInvRepo.save(vi);
		return null;
	}

	@Override
	public boolean deleteVaccineInventory(int inventory_Id) {
		VaccineInventory vi = vaccineInvRepo.findById(inventory_Id).orElseThrow();
		vaccineInvRepo.delete(vi);
		return true;
	}


	@Override
	public VaccineInventory getVaccineInventoryByDate(LocalDate date) {
		VaccineInventory vi = vaccineInvRepo.findByDate(date);
		return vi;
	}

	@Override
	public VaccineInventory getVaccineInventoryByVaccine(Vaccine vaccine) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VaccineInventory> getAllVaccineInventory() {
		List<VaccineInventory> vis = vaccineInvRepo.findAll();
		return vis;
	}

	@Override
	public VaccineInventory getVaccineInventoryById(int id) {
		VaccineInventory vi = vaccineInvRepo.findById(id).orElseThrow();
		return vi;
	}

	
}
