package com.Appointment.Entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "poliklinikler", schema = "hospitalappointment")
@Data
public class Poliklinik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",nullable = true)
    private String name;
    
    @JsonManagedReference("poliklinik-doctor")
    @OneToMany(mappedBy = "poliklinik")
    private List<Doctor> doctors = new ArrayList<>();

    @JsonManagedReference("poliklinik-appointment")
    @OneToMany(mappedBy = "poliklinik")
    private List<Appointment> appointments = new ArrayList<>();
}
