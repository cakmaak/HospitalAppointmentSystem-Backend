package com.Appointment.Dto;

import java.util.List;
import java.util.Set;

import com.Appointment.Enums.Role;

import lombok.Data;

@Data
public class DtoUser {
	
	private Long id;
	private String name;
	private String email;
	private Role role;
	
	

}
