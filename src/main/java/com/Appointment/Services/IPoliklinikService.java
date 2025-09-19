package com.Appointment.Services;


import java.util.List;

import com.Appointment.Dto.DtoPoliklinik;
import com.Appointment.Entity.Poliklinik;

public interface IPoliklinikService {
	
	public Poliklinik savePoliklinik(Poliklinik poliklinik);
	public Poliklinik findPoliklinik(Long id);
	public List<Poliklinik> getPolikliniklist();
	public DtoPoliklinik deletePoliklinik(Long id);
	
	
	

}
