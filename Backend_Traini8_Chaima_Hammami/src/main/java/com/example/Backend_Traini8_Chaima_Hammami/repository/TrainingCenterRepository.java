package com.example.Backend_Traini8_Chaima_Hammami.repository;

import com.example.Backend_Traini8_Chaima_Hammami.Models.TrainingCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingCenterRepository extends JpaRepository<TrainingCenter, Long> {
}