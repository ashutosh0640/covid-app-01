package com.vaccinationApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vaccinationApp.model.Vaccine;

@Repository
public interface VaccineRepository extends JpaRepository<Vaccine, Integer> {
	
	
	public Vaccine findByVaccineName(String name);
}
