package com.Appointment.Dto;

import java.util.List;

import com.Appointment.Entity.Appointment;
import com.Appointment.Entity.Poliklinik;

import lombok.Data;

@Data
public class DtoDoctor {
	
	private String name;
	
	private Long id;
	
	private Poliklinik poliklinik;
	
	private List<Appointment> appointments;

}
