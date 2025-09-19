package com.Appointment.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Service;

import com.Appointment.Dto.DtoPoliklinik;
import com.Appointment.Entity.Poliklinik;
import com.Appointment.Repository.PoliklinikRepo;

@Service
public class PoliklinikServiceimpl implements IPoliklinikService {
	@Autowired
	PoliklinikRepo poliklinikRepo;
	
	
	

	@Override
	public Poliklinik savePoliklinik(Poliklinik poliklinik) {
		poliklinikRepo.save(poliklinik);
		return poliklinik;
	}

	@Override
	public Poliklinik findPoliklinik(Long id) {
		Optional<Poliklinik> optional=poliklinikRepo.findById(id);
		Poliklinik poliklinik=optional.get();
		return poliklinik;
	}

	@Override
	public List<Poliklinik> getPolikliniklist() {
		List<Poliklinik> polikliniks=poliklinikRepo.findAll();
		return polikliniks;
	}

	@Override
	public DtoPoliklinik deletePoliklinik(Long id) {
		Optional<Poliklinik> optional=poliklinikRepo.findById(id);
		Poliklinik poliklinik=optional.get();
		DtoPoliklinik dtoPoliklinik=new DtoPoliklinik();
		dtoPoliklinik.setAppointments(poliklinik.getAppointments());
		dtoPoliklinik.setDoctors(poliklinik.getDoctors());
		dtoPoliklinik.setId(poliklinik.getId());
		dtoPoliklinik.setName(poliklinik.getName());
		
		poliklinikRepo.delete(poliklinik);
		
		return dtoPoliklinik;
	}

}
