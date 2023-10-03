package com.codeclan.example.WhiskyTracker.repositories;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface DistilleryRepository extends JpaRepository<Distillery, Long> {

    List<Distillery> findByRegion(String region);

    List<Distillery> findByWhiskiesAge(Integer whiskyAge);
}
