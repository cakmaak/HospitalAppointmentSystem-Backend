package com.Appointment.Services;

import java.util.List;

import com.Appointment.Dto.DtoDoctor;
import com.Appointment.Entity.Doctor;

public interface IDoctorService {
	
	public Doctor saveDoctor(Doctor doctor,Long poliklinikid);
	public Doctor findDoctor(Long id);
	public List<DtoDoctor> getalldoctors();
	public Doctor deleteDoctor(Long id);

}
