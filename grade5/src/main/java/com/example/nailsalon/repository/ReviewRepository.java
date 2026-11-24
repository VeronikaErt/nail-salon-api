package com.example.nailsalon.repository;
import com.example.nailsalon.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ReviewRepository extends JpaRepository<Review,Long> {}
