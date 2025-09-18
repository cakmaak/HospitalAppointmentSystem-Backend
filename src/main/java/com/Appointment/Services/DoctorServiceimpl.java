package com.Appointment.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Appointment.Dto.DtoDoctor;
import com.Appointment.Entity.Doctor;
import com.Appointment.Repository.DoctorRepo;

@Service
public class DoctorServiceimpl implements IDoctorService {
	@Autowired
	DoctorRepo doctorRepo;
	
	@Autowired
	IPoliklinikService poliklinikService;
	
	@Override
	public Doctor saveDoctor(Doctor doctor,Long poliklinikid) {
		doctor.setPoliklinik(poliklinikService.findPoliklinik(poliklinikid));
		doctorRepo.save(doctor);	
		return doctor;
		
	}

	@Override
	public Doctor findDoctor(Long id) {
		Optional<Doctor> doctOptional=doctorRepo.findById(id);
		Doctor doctor=doctOptional.get();
		return doctor;
	}
	
	@Override
	public List<DtoDoctor> getalldoctors() {
	List<Doctor> doctors=doctorRepo.findAll();
		List<DtoDoctor> dtoDoctors= new ArrayList<>();
		for (Doctor doctor : doctors) {
			DtoDoctor dtoDoctor=new DtoDoctor();
			dtoDoctor.setAppointments(doctor.getAppointments());
			dtoDoctor.setId(doctor.getId());
			dtoDoctor.setName(doctor.getName());
			dtoDoctor.setPoliklinik(dtoDoctor.getPoliklinik());
			dtoDoctors.add(dtoDoctor);
			
		}
		return dtoDoctors;
		
	}

}
