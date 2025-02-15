package com.example.Backend_Traini8_Chaima_Hammami.controllers;

import com.example.Backend_Traini8_Chaima_Hammami.Models.TrainingCenter;
import com.example.Backend_Traini8_Chaima_Hammami.repository.TrainingCenterRepository;
import com.example.Backend_Traini8_Chaima_Hammami.service.TrainingCenterService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/training-centers")
public class TrainingCenterController {

    @Autowired
    private TrainingCenterRepository trainingCenterRepository;

    private final TrainingCenterService service;

    public TrainingCenterController(TrainingCenterService service) {
        this.service = service;
    }

    // POST API: Create a new training center
    @PostMapping
    public ResponseEntity<?> createTrainingCenter(@Valid @RequestBody TrainingCenter trainingCenter) {

        System.out.println(" Received JSON Payload: " + trainingCenter);
        System.out.println(" Center Name: " + trainingCenter.getCenterName());
        System.out.println(" Center Code: " + trainingCenter.getCenterCode());
        System.out.println(" Address: " + trainingCenter.getAddress());
        System.out.println(" Courses Offered: " + trainingCenter.getCoursesOffered());
        System.out.println(" Contact Email: " + trainingCenter.getContactEmail());

        return ResponseEntity.status(201).body(service.saveTrainingCenter(trainingCenter));
    }

    // GET API: Retrieve all training centers
    @GetMapping
    public ResponseEntity<List<TrainingCenter>> getAllTrainingCenters() {
        List<TrainingCenter> centers = service.getAllTrainingCenters();
        return ResponseEntity.ok(centers.isEmpty() ? List.of() : centers);
    }

    // GET API with Filtering
    @GetMapping("/filter")
    public ResponseEntity<List<TrainingCenter>> getFilteredTrainingCenters(
            @RequestParam(required = false) String centerName,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) Integer studentCapacity
    ) {
        List<TrainingCenter> filteredCenters = trainingCenterRepository.findAll().stream()
                .filter(tc -> centerName == null || tc.getCenterName().toLowerCase().contains(centerName.toLowerCase()))
                .filter(tc -> city == null || (tc.getAddress() != null && tc.getAddress().getCity().toLowerCase().contains(city.toLowerCase())))
                .filter(tc -> studentCapacity == null || tc.getStudentCapacity() >= studentCapacity)
                .collect(Collectors.toList());

        return ResponseEntity.ok(filteredCenters);
    }
}
