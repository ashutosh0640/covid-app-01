package com.vaccinationApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaccinationApp.model.Vaccine;
import com.vaccinationApp.repository.VaccineRepository;


@Service
public class VaccineServiceImp implements VaccineService {
	
	@Autowired
	private VaccineRepository vaccineRepo;
	
	
	
	@Override
	public Vaccine getVaccineByName(String vName) {
		Vaccine vacc = vaccineRepo.findByVaccineName(vName);
		if(vacc == null) {
			//throw
		}
		return vacc;
	}

	@Override
	public Vaccine getVaccineById(int vId) {
		Vaccine vacc = vaccineRepo.findById(vId).orElseThrow();
		return vacc;
	}

	@Override
	public Vaccine addVaccine(Vaccine vaccine) {
		Optional<Vaccine> vacc = vaccineRepo.findById(vaccine.getVaccineId());
		if(vacc.isPresent()) {
			//throw
		}
		vaccineRepo.save(vaccine);
		return vaccine;
	}

	@Override
	public Vaccine updateVaccine(Vaccine vaccine) {
		Vaccine vacc = vaccineRepo.findById(vaccine.getVaccineId()).orElseThrow();
		vacc.setVaccineName(vaccine.getVaccineName());
		vacc.setDescription(vaccine.getDescription());
		return vacc;
	}

	@Override
	public boolean deleteVaccine(int vaccineId) {
		vaccineRepo.deleteById(vaccineId);
		return true;
	}

	@Override
	public List<Vaccine> getAllVaccine() {
		List<Vaccine> vaccines = vaccineRepo.findAll();
		return vaccines;
	}

}
