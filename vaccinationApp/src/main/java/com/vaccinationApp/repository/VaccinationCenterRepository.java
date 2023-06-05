package com.vaccinationApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vaccinationApp.model.VaccinationCenter;

@Repository
public interface VaccinationCenterRepository extends JpaRepository<VaccinationCenter, Integer> {

}
