package com.Appointment.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Appointment.Dto.DtoPoliklinik;
import com.Appointment.Entity.Poliklinik;
import com.Appointment.Services.IPoliklinikService;

import io.swagger.v3.oas.annotations.Operation;


@RestController
@RequestMapping("/appointment/poliklinik")
public class PoliklinikControllerimpl implements IPoliklinikController {
	@Autowired
	IPoliklinikService poliklinikService;

	@Operation(summary = "save poliklinik for admin")
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/savepoliklinik")
	@Override
	public Poliklinik savePoliklinik(@RequestBody Poliklinik poliklinik) {
		
		return poliklinikService.savePoliklinik(poliklinik);
	}
	
	@Operation(summary = "find poliklinik by id")
	@GetMapping("/findpoliklinikbyid/{id}")
	@Override
	public Poliklinik findPoliklinik(@PathVariable Long id) {
		return poliklinikService.findPoliklinik(id);
	}
	
	@Operation(summary = "get all klinik")
	@GetMapping("/getallklinik")
	@Override
	public List<Poliklinik> getPolikliniklist() {
		
		return poliklinikService.getPolikliniklist();
	}
	
	@DeleteMapping("/deletepoliklinik/{id}")
	@Operation(summary = "delete poliklinik for admins")
	@PreAuthorize("hasAuthority('ADMIN')")
	@Override
	public DtoPoliklinik deletePoliklinik(@PathVariable  Long id) {
		
		return poliklinikService.deletePoliklinik(id);
	}

}
