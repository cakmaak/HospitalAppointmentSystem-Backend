package com.Appointment.Controller;

import java.util.List;

import com.Appointment.Entity.Doctor;

public interface IDoctorController {
	
	public Doctor saveDoctor(Doctor doctor,Long poliklinikid);
	public List<Doctor> getalldoctors();
}
