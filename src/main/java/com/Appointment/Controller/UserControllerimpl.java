package com.Appointment.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Appointment.Dto.DtoUser;
import com.Appointment.Entity.User;
import com.Appointment.Services.IUserService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/appointment/user")
public class UserControllerimpl implements IUserController {
	@Autowired
	IUserService userService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Operation(summary = "getme")
	@GetMapping("/getuser")
	@Override
	public User getuser() {
		
		return userService.getuser();
	}

	@Override
	public User getUserbyEmail(String email) {
		
		return null;
	}
	
	@Operation(summary = "getuser")
	@GetMapping("/GetUser")
	@Override
	public DtoUser Getuser() {
		
		return userService.Getuser();
	}
	
	@Operation(summary = "signup user")
	@PostMapping("/saveuser")
	@Override
	public User saveUser(@RequestBody User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userService.saveUser(user);
	}
	
	@Operation(summary = "signup for admin")
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/saveadmin")
	@Override
	public User saveuseradmin(@RequestBody User admin) {
		admin.setPassword(passwordEncoder.encode(admin.getPassword()));
		return userService.saveuseradmin(admin);
	}

}
