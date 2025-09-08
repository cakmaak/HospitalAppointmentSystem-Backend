package com.Appointment.Controller;

import com.Appointment.Dto.DtoUser;
import com.Appointment.Entity.User;

public interface IUserController   {
	
	public User getuser();
	public User getUserbyEmail(String email);
	public DtoUser Getuser();
	public User saveUser(User user);
	public User saveuseradmin(User admin);
	


}
