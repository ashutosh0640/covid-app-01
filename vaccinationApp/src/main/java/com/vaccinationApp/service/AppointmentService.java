package com.vaccinationApp.service;

import java.util.List;

import com.vaccinationApp.model.Appointment;

public interface AppointmentService {
	
	
	public Appointment getAppointment(long bookingId);
	
	public Appointment addAppointment(Appointment app);
	
	public Appointment updateAppointment(Appointment app);
	
	public boolean deleteAppointment(long bookingId);
	
	public List<Appointment> getAllAppointment();
}
