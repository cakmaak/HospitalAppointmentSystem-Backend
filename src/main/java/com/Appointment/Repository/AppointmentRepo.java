package com.Appointment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Appointment.Entity.Appointment;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Long> {

}
