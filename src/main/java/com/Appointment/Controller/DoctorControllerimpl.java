package com.Appointment.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
