package com.vaccinationApp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vaccinationApp.model.VaccineRegistration;


@Repository
public interface VaccineRegistrationRepository extends JpaRepository<VaccineRegistration, Long> {

}
