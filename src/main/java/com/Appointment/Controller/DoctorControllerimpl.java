package com.Appointment.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Appointment.Dto.DtoDoctor;
import com.Appointment.Entity.Doctor;
import com.Appointment.Services.IDoctorService;

import io.swagger.v3.oas.annotations.Operation;


@RestController
@RequestMapping("/appointment/doctor")
public class DoctorControllerimpl implements IDoctorController {
	
	@Autowired
	IDoctorService doctorService;
	
	@Operation(summary = "save doctor ")
	@PostMapping("/savedoctor/{poliklinikid}")
	@Override
	public Doctor saveDoctor(@RequestBody Doctor doctor,@PathVariable Long poliklinikid) {
		return doctorService.saveDoctor(doctor,poliklinikid);
	}
	
	@Operation(summary = "get all doctors")
	@GetMapping("/getalldoctors")
	@Override
	public List<DtoDoctor> getalldoctors() {
		
		return doctorService.getalldoctors();
	}
	
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@Operation(summary = "delete doctor for admins")
	@DeleteMapping("/deletedoctor")
	@Override
	public Doctor deleteDoctor(@PathVariable Long id) {
		return doctorService.deleteDoctor(id);
	}

}
