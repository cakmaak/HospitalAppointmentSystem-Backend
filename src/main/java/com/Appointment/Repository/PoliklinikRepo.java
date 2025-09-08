package com.Appointment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Appointment.Entity.Poliklinik;

@Repository
public interface PoliklinikRepo extends JpaRepository<Poliklinik,Long>{

}
