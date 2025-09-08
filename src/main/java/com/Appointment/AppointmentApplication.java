package com.Appointment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(
	    scanBasePackages = "com.Appointment"
	)
	@EntityScan("com.Appointment.Entity")
	@EnableJpaRepositories("com.Appointment.Repository")
	public class AppointmentApplication {
	    public static void main(String[] args) {
	        SpringApplication.run(AppointmentApplication.class, args);
	    }
	}