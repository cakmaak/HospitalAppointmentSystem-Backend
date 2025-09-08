package com.Appointment.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Appointment.Entity.Poliklinik;
import com.Appointment.Services.IPoliklinikService;


@RestController
@RequestMapping("/appointment/poliklinik")
public class PoliklinikControllerimpl implements IPoliklinikController {
	@Autowired
	IPoliklinikService poliklinikService;

	
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/savepoliklinik")
	@Override
	public Poliklinik savePoliklinik(@RequestBody Poliklinik poliklinik) {
		
		return poliklinikService.savePoliklinik(poliklinik);
	}

	@Override
	public Poliklinik findPoliklinik(Long id) {
		return null;
	}
	
	@GetMapping("/getallklinik")
	@Override
	public List<Poliklinik> getPolikliniklist() {
		
		return poliklinikService.getPolikliniklist();
	}

}
