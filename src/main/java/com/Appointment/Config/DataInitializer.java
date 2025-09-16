package com.Appointment.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.Appointment.Entity.User;
import com.Appointment.Enums.Role;
import com.Appointment.Repository.UserRepo;
import com.Appointment.Services.IUserService;

import java.util.Optional;

@Component
public class DataInitializer implements CommandLineRunner {

    private final IUserService userService;
    
    @Autowired
    UserRepo userRepo;

    public DataInitializer(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        Optional<User> adminOpt = userRepo.findByEmail("admin@admin.com");

        if (adminOpt.isEmpty()) {
            User admin = new User();
            admin.setName("Default Admin");
            admin.setEmail("admin@admin.com");
            admin.setPassword(new BCryptPasswordEncoder().encode("123456"));
            admin.setRole(Role.ADMIN);

            userService.saveuseradmin(admin);

            System.out.println("✅ Default admin oluşturuldu: admin@admin.com / 123456");
        } else {
            System.out.println("ℹ️ Admin zaten mevcut: " + adminOpt.get().getEmail());
        }
    }
}
