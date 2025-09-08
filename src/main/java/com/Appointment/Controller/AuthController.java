package com.Appointment.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import com.Appointment.Dto.AuthResponse;
import com.Appointment.Dto.DtoLogin;
import com.Appointment.Dto.DtoUser;
import com.Appointment.Entity.User;
import com.Appointment.Security.JwtService;
import com.Appointment.Services.IUserService;

@RestController
@RequestMapping("/appointment")
public class AuthController {

    @Autowired private AuthenticationManager authManager;
    @Autowired private JwtService jwtService;
    @Autowired private IUserService userService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody DtoLogin req) {
        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(req.getEmail(), req.getPassword())
        );
        UserDetails principal = (UserDetails) authentication.getPrincipal();

    
        User user = userService.getUserbyEmail(principal.getUsername());

        
        String token = jwtService.generateToken(user);

        return ResponseEntity.ok(new AuthResponse(token));
    }
}