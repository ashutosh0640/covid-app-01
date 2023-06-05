package com.vaccinationApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaccinationApp.DTO.ApiResponse;
import com.vaccinationApp.exceptions.NotFoundException;
import com.vaccinationApp.model.Appointment;
import com.vaccinationApp.repository.AppointmentRepository;

@Service
public class AppointmentServiceImp implements AppointmentService {
	
	@Autowired
	private AppointmentRepository appRepo;
	
	@Override
	public Appointment addAppointment(Appointment app) {
		Appointment appoint = appRepo.save(app);
		return appoint;
	}
	
	@Override
	public Appointment getAppointment(long bookingId) {
		Appointment appointment = appRepo.findById(bookingId).orElseThrow(()->new NotFoundException("Appoinment with id: "+bookingId+", is not booked."));
		return appointment;
	}

	

	@Override
	public Appointment updateAppointment(Appointment app) {
		Appointment appointment = appRepo.findById(app.getBookingId()).orElseThrow();
		appointment.setMobileNo(app.getMobileNo());
		appointment.setDateOfBooking(app.getDateOfBooking());
		appointment.setSlot(app.getSlot());
		appointment.setCenter_code(app.getCenter_code());
		appRepo.save(appointment);
		return appointment;
		
	}

	@Override
	public boolean deleteAppointment(long bookingId) {
		Appointment appointment = appRepo.findById(bookingId).orElseThrow();
		appRepo.delete(appointment);
		return true;
		
	}

	@Override
	public List<Appointment> getAllAppointment() {
		List<Appointment> appoints = appRepo.findAll();
		return appoints;
		
	}

}
