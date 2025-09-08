package com.Appointment.Services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import com.Appointment.Repository.AppointmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Service;
import org.springframework.web.cors.CorsConfigurationSource;
import com.Appointment.Dto.DtoAppointment;
import com.Appointment.Entity.Appointment;
import com.Appointment.Entity.User;
import com.Appointment.Enums.Status;


@Service
public class AppointmentServiceimpl implements IAppointmentService {

    private final CorsConfigurationSource corsConfigurationSource;

    
	
	@Autowired
	IDoctorService doctorService;
	
	@Autowired
	IUserService userService;
	
	@Autowired
	SecurityFilterChain securityFilterChain;
	
	
	@Autowired
	IPoliklinikService poliklinikService;
	
	@Autowired
	AppointmentRepo appointmentRepo;


    AppointmentServiceimpl(CorsConfigurationSource corsConfigurationSource) {
        this.corsConfigurationSource = corsConfigurationSource;
    }

 

	@Override
	public DtoAppointment saveAppointment(Appointment appointment,Long poliklinikid, Long doctorid) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth == null || !auth.isAuthenticated() || "anonymousUser".equals(auth.getPrincipal())) {
	        throw new RuntimeException("Lütfen giriş yapınız.");
	    }

	    String email = ((UserDetails) auth.getPrincipal()).getUsername();
	    User user = userService.getUserbyEmail(email);

	   
		
		appointment.setUser(user);
		appointment.setDoctor(doctorService.findDoctor(doctorid));
		appointment.setPoliklinik(poliklinikService.findPoliklinik(poliklinikid));
		
		appointmentRepo.save(appointment);
		
		
		DtoAppointment dtoAppointment=new DtoAppointment();
		dtoAppointment.setDoctorname(appointment.getDoctor().getName());
		dtoAppointment.setPoliklinikname(appointment.getPoliklinik().getName());
		dtoAppointment.setTarih(appointment.getTarih());
		dtoAppointment.setUsername(user.getName());
		dtoAppointment.setId(appointment.getId());
		
		
		
		return dtoAppointment;
	}




	@Override
	public DtoAppointment putAcceptAppointment(Long id) {
		
	    Optional<Appointment> optional = appointmentRepo.findById(id);
	    if (optional.isEmpty()) {
	        throw new RuntimeException("Appointment bulunamadi id: " + id);
	    }
	    
	    
	    Appointment appointment=optional.get();
	    appointment.setStatus(Status.ONAYLANDI);
	    appointmentRepo.save(appointment);
	    
	    DtoAppointment dtoAppointment=new DtoAppointment();
	    dtoAppointment.setDoctorname(appointment.getDoctor().getName());
	    dtoAppointment.setDurum(appointment.getStatus());
	    dtoAppointment.setId(appointment.getId());
	    dtoAppointment.setPoliklinikname(appointment.getPoliklinik().getName());
	    dtoAppointment.setTarih(appointment.getTarih());
	    dtoAppointment.setUsername(appointment.getUser().getName());
		
		return dtoAppointment;
	}



	@Override
	public DtoAppointment putRejectedAppointment(Long id) {
		 Optional<Appointment> optional = appointmentRepo.findById(id);
		    if (optional.isEmpty()) {
		        throw new RuntimeException("Appointment bulunamadi id: " + id);
		    }
		    
		    
		    Appointment appointment=optional.get();
		    appointment.setStatus(Status.REDDEDİLDİ);
		    appointmentRepo.save(appointment);
		    
		    DtoAppointment dtoAppointment=new DtoAppointment();
		    dtoAppointment.setDoctorname(appointment.getDoctor().getName());
		    dtoAppointment.setDurum(appointment.getStatus());
		    dtoAppointment.setId(appointment.getId());
		    dtoAppointment.setPoliklinikname(appointment.getPoliklinik().getName());
		    dtoAppointment.setTarih(appointment.getTarih());
		    dtoAppointment.setUsername(appointment.getUser().getName());
			
			return dtoAppointment;
	}



	@Override
	public DtoAppointment cancelAppointment(Long id, Authentication authentication) {
		Optional<Appointment> optional=appointmentRepo.findById(id);
		if (optional.isEmpty()) {
		throw new RuntimeException("kullanıcı bulunammadı");
		}
		
		Appointment appointment=optional.get();
		
		String loginEmail=authentication.getName();
		User loginUser=userService.getUserbyEmail(loginEmail);
		
		  if (loginUser == null || !appointment.getUser().getId().equals(loginUser.getId())) {
		        throw new RuntimeException("Bu randevuyu iptal etmeye yetkiniz yok");
		    }
		  
		  LocalDateTime now = LocalDateTime.now();
		    if (now.isAfter(appointment.getTarih().minusDays(1))) {
		        throw new RuntimeException("İptal edilemez, randevudan 24 saat öncesine kadar iptal edilebilir");
		    }

		appointment.setStatus(Status.İPTAL);
		appointmentRepo.save(appointment);
		
		DtoAppointment dto=new DtoAppointment();
		dto.setId(appointment.getId());
	    dto.setDoctorname(appointment.getDoctor().getName());
	    dto.setPoliklinikname(appointment.getPoliklinik().getName());
	    dto.setTarih(appointment.getTarih());
	    dto.setUsername(appointment.getUser().getName());
	    dto.setDurum(appointment.getStatus());

	    return dto;
	}



	

}
