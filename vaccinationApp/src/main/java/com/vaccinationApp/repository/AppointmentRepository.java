package com.vaccinationApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vaccinationApp.model.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}
