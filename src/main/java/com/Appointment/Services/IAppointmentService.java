package com.Appointment.Services;


import org.springframework.security.core.Authentication;
import com.Appointment.Dto.DtoAppointment;
import com.Appointment.Entity.Appointment;

public interface IAppointmentService {
	
	public DtoAppointment saveAppointment(Appointment appointment,Long poliklinikid,Long doctorid);
	public DtoAppointment putAcceptAppointment(Long id);
	public DtoAppointment putRejectedAppointment(Long id);
	public DtoAppointment cancelAppointment(Long id,Authentication authentication);
	

}
