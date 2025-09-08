package com.Appointment.Dto;


import java.time.LocalDateTime;

import com.Appointment.Enums.Status;

import lombok.Data;

@Data
public class DtoAppointment {
	
	private Long id;
	
	private String username;
	
	private String doctorname;
	
	private String poliklinikname;
	
	private LocalDateTime tarih;
	
	private Status durum=Status.BEKLEMEDE;
	

}
