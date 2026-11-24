package com.example.nailsalon.repository;
import com.example.nailsalon.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AppointmentRepository extends JpaRepository<Appointment,Long> {}
