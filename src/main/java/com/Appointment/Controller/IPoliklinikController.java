package com.Appointment.Controller;

import java.util.List;

import com.Appointment.Dto.DtoPoliklinik;
import com.Appointment.Entity.Poliklinik;

public interface IPoliklinikController {
	public Poliklinik savePoliklinik(Poliklinik poliklinik);
	public Poliklinik findPoliklinik(Long id);
	public List<Poliklinik> getPolikliniklist();
	public DtoPoliklinik deletePoliklinik(Long id);
	

}
