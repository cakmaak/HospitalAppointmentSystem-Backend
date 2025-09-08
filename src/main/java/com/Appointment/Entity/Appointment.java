package com.Appointment.Entity;


import java.time.LocalDate;
import java.time.LocalDateTime;

import com.Appointment.Enums.Status;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "appointments", schema = "hospitalappointment")
@Data
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tarih",nullable = false)
    private LocalDateTime tarih;
    
    @Column(name = "durum")
    @Enumerated(EnumType.STRING)
    private Status status = Status.BEKLEMEDE;

    
    @JsonBackReference("user-appointment")
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    
    @JsonBackReference("poliklinik-appointment")
    @ManyToOne
    @JoinColumn(name = "poliklinik_id", nullable = false)
    private Poliklinik poliklinik;

    @ManyToOne
    @JsonBackReference("doctor-appointment")
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;
}

