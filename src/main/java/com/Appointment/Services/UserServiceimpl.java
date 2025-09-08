package com.Appointment.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.Appointment.Dto.DtoUser;
import com.Appointment.Entity.User;
import com.Appointment.Enums.Role;
import com.Appointment.Repository.UserRepo;

@Service
public class UserServiceimpl implements IUserService  {
	@Autowired
	UserRepo userRepo;
	
	
	@Override
	public User getUserbyEmail(String email) {
		System.out.println("DB'de aranıyor (IgnoreCase): " + email);

	    Optional<User> userOpt = userRepo.findByEmailIgnoreCase(email.trim());

	    if(userOpt.isPresent()) {
	        User user = userOpt.get();

	        System.out.println("Kullanıcı bulundu: " + user.getEmail());

	        return user;
	    } else {
	        throw new RuntimeException("kullanıcı bulunamadi");
	    }
	}

	@Override
	public User getuser() {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth == null || !auth.isAuthenticated() || auth.getPrincipal().equals("anonymousUser")) {
	        throw new RuntimeException("Lütfen giriş yapınız.");
	    }
	    String email;
	    Object principal = auth.getPrincipal();
	    if (principal instanceof UserDetails) {
	        email = ((UserDetails) principal).getUsername();
	    } else if (principal instanceof User) {
	        email = ((User) principal).getEmail();
	    } else {
	        throw new RuntimeException("Bilinmeyen principal tipi");
	    }
	    
	    User user=getUserbyEmail(email);

		return user;

	}

	@Override
	public DtoUser Getuser() {
		User user =getuser();
		DtoUser dtoUser=new DtoUser();
		dtoUser.setEmail(user.getEmail());
		dtoUser.setId(user.getId());
		dtoUser.setName(user.getName());
		dtoUser.setRole(user.getRole());
		return dtoUser;
	}

	@Override
	public User saveUser(User user) {
		userRepo.save(user);
		user.setRole(Role.USER);

		return user;
	}

	@Override
	public User saveuseradmin(User admin) {
		admin.setRole(Role.ADMIN);
		userRepo.save(admin);
		return admin;
		
		
	}
	


}
