package com.Appointment.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Appointment.Dto.DtoAppointment;
import com.Appointment.Entity.Appointment;
import com.Appointment.Services.IAppointmentService;

import io.swagger.v3.oas.annotations.Operation;


@RestController
@RequestMapping("/appointment")
public class AppointmentControllerimpl implements IAppointmentController {
	
	@Autowired
	IAppointmentService appointmentService;

	@Operation(summary = "save appointment")
	@PostMapping("/saveappointment/{poliklinikid}/{doctorid}")
	@Override
	public DtoAppointment saveAppointment(@RequestBody Appointment appointment,@PathVariable Long poliklinikid,@PathVariable Long doctorid) {

		return appointmentService.saveAppointment(appointment, poliklinikid, doctorid);
	}

	@Operation(summary = "admin accept appointment")
	@PreAuthorize("hasAuthority('ADMIN')")
	@PutMapping("/acceptappointment/{id}")
	@Override
	public DtoAppointment putAcceptAppointment(@PathVariable Long id) {
		
		return appointmentService.putAcceptAppointment(id) ;
	}
	@Operation(summary = "admin rejected appointment")
	@PreAuthorize("hasAuthority('ADMIN')")
	@PutMapping("/rejectedappointment/{id}")
	@Override
	public DtoAppointment putRejectedAppointment(@PathVariable Long id) {
		
		return appointmentService.putRejectedAppointment(id);
	}
	
	@Operation(summary = "user cancel appointment")
	@PutMapping("/cancelappointment/{id}")
	@Override
	public DtoAppointment cancelAppointment(@PathVariable Long id, Authentication authentication) {
		
		return appointmentService.cancelAppointment(id, authentication);
	}
	
	@Operation(summary = "getallappointment for admin see all appointments")
	@GetMapping("/getallappointment")
	@PreAuthorize("hasAuthority('ADMIN')")
	@Override
	public List<DtoAppointment> getallappointment() {
	
		return appointmentService.getallappointment();
	}
	
	@Operation(summary = "get all appointment for user see own appointment")
	@GetMapping("/gettallappointmentuser")
	@Override
	public List<DtoAppointment> getallappointmentforuser() {
		
		return appointmentService.getallappointmentforuser();
	}

}
