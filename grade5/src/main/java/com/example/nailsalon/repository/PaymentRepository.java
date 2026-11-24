package com.example.nailsalon.repository;
import com.example.nailsalon.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PaymentRepository extends JpaRepository<Payment,Long> {}
