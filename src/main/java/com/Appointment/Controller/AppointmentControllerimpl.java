package com.Appointment.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Appointment.Dto.DtoAppointment;
import com.Appointment.Entity.Appointment;
import com.Appointment.Services.IAppointmentService;


@RestController
@RequestMapping("/appointment")
public class AppointmentControllerimpl implements IAppointmentController {
	
	@Autowired
	IAppointmentService appointmentService;

	
	@PostMapping("/saveappointment/{poliklinikid}/{doctorid}")
	@Override
	public DtoAppointment saveAppointment(@RequestBody Appointment appointment,@PathVariable Long poliklinikid,@PathVariable Long doctorid) {

		return appointmentService.saveAppointment(appointment, poliklinikid, doctorid);
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@PutMapping("/acceptappointment/{id}")
	@Override
	public DtoAppointment putAcceptAppointment(@PathVariable Long id) {
		
		return appointmentService.putAcceptAppointment(id) ;
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@PutMapping("/rejectedappointment/{id}")
	@Override
	public DtoAppointment putRejectedAppointment(@PathVariable Long id) {
		
		return appointmentService.putRejectedAppointment(id);
	}

	@PutMapping("/cancelappointment/{id}")
	@Override
	public DtoAppointment cancelAppointment(@PathVariable Long id, Authentication authentication) {
		
		return appointmentService.cancelAppointment(id, authentication);
	}

}
