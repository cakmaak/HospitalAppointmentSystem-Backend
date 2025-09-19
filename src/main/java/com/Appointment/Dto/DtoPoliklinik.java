package com.Appointment.Dto;

import java.util.List;

import com.Appointment.Entity.Appointment;
import com.Appointment.Entity.Doctor;

import lombok.Data;

@Data
public class DtoPoliklinik {
	private Long id;
	
	private String name;
	
	private List<Doctor> doctors;
	
	private List<Appointment> appointments;

}
