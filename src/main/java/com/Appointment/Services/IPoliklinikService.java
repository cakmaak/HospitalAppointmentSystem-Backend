package com.Appointment.Services;


import java.util.List;

import com.Appointment.Entity.Poliklinik;

public interface IPoliklinikService {
	
	public Poliklinik savePoliklinik(Poliklinik poliklinik);
	public Poliklinik findPoliklinik(Long id);
	public List<Poliklinik> getPolikliniklist();
	public Poliklinik deletePoliklinik(Long id);
	
	
	

}
