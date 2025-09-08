package com.Appointment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Appointment.Entity.Doctor;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Long> {

}
