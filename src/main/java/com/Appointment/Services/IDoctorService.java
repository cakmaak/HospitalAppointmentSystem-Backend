package com.Appointment.Services;

import com.Appointment.Entity.Doctor;

public interface IDoctorService {
	
	public Doctor saveDoctor(Doctor doctor,Long poliklinikid);
	public Doctor findDoctor(Long id);

}
