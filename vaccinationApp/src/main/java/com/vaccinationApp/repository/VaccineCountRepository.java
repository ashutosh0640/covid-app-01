package com.vaccinationApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vaccinationApp.model.VaccineCount;


@Repository
public interface VaccineCountRepository extends JpaRepository<VaccineCount, Integer> {

}
