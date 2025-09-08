package com.Appointment.Entity;

import java.util.ArrayList;
import java.util.List;

import com.Appointment.Enums.Role;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "users",schema = "hospitalappointment")
@Data
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name",nullable = false)
	private String name;
	
	@Column(name = "email",unique = true)
	private String email;
	
	@Column(name = "password",nullable = false)
	private String password;
	
	@Column(name = "rol",nullable = false)
	@Enumerated(EnumType.STRING)
	private Role role=Role.USER;
	
	@JsonManagedReference("user-appointment")
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Appointment> appointments=new ArrayList<>();
	
	
	
	
	

}
