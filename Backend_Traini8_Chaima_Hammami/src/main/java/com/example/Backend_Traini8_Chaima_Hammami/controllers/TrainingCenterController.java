package com.example.Backend_Traini8_Chaima_Hammami.controllers;

import com.example.Backend_Traini8_Chaima_Hammami.Models.TrainingCenter;
import com.example.Backend_Traini8_Chaima_Hammami.service.TrainingCenterService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/training-centers")
public class TrainingCenterController {

    private final TrainingCenterService service;

    public TrainingCenterController(TrainingCenterService service) {
        this.service = service;
    }

    // POST API: Create a new training center
    @PostMapping
    public ResponseEntity<?> createTrainingCenter(@Valid @RequestBody TrainingCenter trainingCenter) {

        System.out.println(" Received JSON Payload: " + trainingCenter);
        System.out.println(" Center Name: " + trainingCenter.getCenterName());
        System.out.println(" Id: " + trainingCenter.getId());
        System.out.println(" Center Code: " + trainingCenter.getCenterCode());
        System.out.println(" Address: " + trainingCenter.getAddress());
        System.out.println(" Courses Offered: " + trainingCenter.getCoursesOffered());
        System.out.println(" Contact Email: " + trainingCenter.getContactEmail());

        return ResponseEntity.ok(service.saveTrainingCenter(trainingCenter));
    }

    // GET API: Retrieve all training centers
    @GetMapping
    public ResponseEntity<List<TrainingCenter>> getAllTrainingCenters() {
        return ResponseEntity.ok(service.getAllTrainingCenters());
    }
}