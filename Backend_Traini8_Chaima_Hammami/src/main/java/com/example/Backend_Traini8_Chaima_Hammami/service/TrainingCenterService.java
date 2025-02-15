package com.example.Backend_Traini8_Chaima_Hammami.service;

import com.example.Backend_Traini8_Chaima_Hammami.Models.TrainingCenter;
import com.example.Backend_Traini8_Chaima_Hammami.repository.TrainingCenterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingCenterService {

    private final TrainingCenterRepository repository;

    public TrainingCenterService(TrainingCenterRepository repository) {
        this.repository = repository;
    }

    public TrainingCenter saveTrainingCenter(TrainingCenter trainingCenter) {
        return repository.save(trainingCenter);
    }

    public List<TrainingCenter> getAllTrainingCenters() {
        return repository.findAll();
    }
}