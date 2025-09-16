package com.Appointment.Controller;

import java.util.List;

import org.springframework.security.core.Authentication;

import com.Appointment.Dto.DtoAppointment;
import com.Appointment.Entity.Appointment;

public interface IAppointmentController {
	
	public DtoAppointment saveAppointment(Appointment appointment,Long poliklinikid,Long doctorid);
	public DtoAppointment putAcceptAppointment(Long id);
	public DtoAppointment putRejectedAppointment(Long id);
	public DtoAppointment cancelAppointment(Long id,Authentication authentication);
	public List<DtoAppointment> getallappointment();
	public List<DtoAppointment> getallappointmentforuser();

}
