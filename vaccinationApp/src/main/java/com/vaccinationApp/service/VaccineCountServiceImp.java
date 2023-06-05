package com.vaccinationApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaccinationApp.model.VaccineCount;
import com.vaccinationApp.repository.VaccineCountRepository;


@Service
public class VaccineCountServiceImp implements VaccineCountService{
	
	
	@Autowired
	private VaccineCountRepository vcr;

	
	@Override
	public VaccineCount saveVaccineCount(VaccineCount vaccineCount) {
		VaccineCount vc = vcr.save(vaccineCount);
		return vc;
	}
	
	
	@Override
	public VaccineCount getVaccineCountById(int id) {
		VaccineCount vc = vcr.findById(id).orElseThrow();
		return vc;
	}

	@Override
	public VaccineCount updateVaccineCount(VaccineCount vaccineCount) {
		VaccineCount vc = vcr.findById(vaccineCount.getVCountId()).orElseThrow();
		vc.setPrice(vaccineCount.getPrice());
		vc.setQuantity(vaccineCount.getQuantity());
		vc.setInventory_id(vaccineCount.getInventory_id());
		vc.setVaccine_id(vaccineCount.getVaccine_id());
		VaccineCount newVc = vcr.save(vc);
		return newVc;
	}

	@Override
	public boolean deleteVaccineCount(int id) {
		VaccineCount vc = vcr.findById(id).orElseThrow();
		vcr.delete(vc);
		return true;
	}

	

	

}
