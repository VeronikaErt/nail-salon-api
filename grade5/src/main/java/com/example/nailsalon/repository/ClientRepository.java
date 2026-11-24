package com.example.nailsalon.repository;
import com.example.nailsalon.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ClientRepository extends JpaRepository<Client,Long> {}
