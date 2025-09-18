package com.Appointment.Services;

import java.util.List;

import com.Appointment.Entity.Doctor;

public interface IDoctorService {
	
	public Doctor saveDoctor(Doctor doctor,Long poliklinikid);
	public Doctor findDoctor(Long id);
	public List<Doctor> getalldoctors();

}
