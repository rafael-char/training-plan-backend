package com.simplavolei.trainingplanservice.controllers;

import com.simplavolei.trainingplanservice.models.TrainingPlan;
import com.simplavolei.trainingplanservice.services.TrainingPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trainingplans")
public class TrainingPlanController {

    @Autowired
    private TrainingPlanService trainingPlanService;

    @PostMapping
    public TrainingPlan createTrainingPlan(@RequestBody TrainingPlan trainingPlan) {
        return trainingPlanService.createTrainingPlan(trainingPlan);
    }

    @PutMapping("/{id}")
    public TrainingPlan updateTrainingPlan(@PathVariable Long id, @RequestBody TrainingPlan trainingPlan) {
        return trainingPlanService.updateTrainingPlan(id, trainingPlan);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrainingPlan(@PathVariable Long id) {
        trainingPlanService.deleteTrainingPlan(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<TrainingPlan> getAllTrainingPlans() {
        return trainingPlanService.getAllTrainingPlans();
    }

    @GetMapping("/{id}")
    public TrainingPlan getTrainingPlanById(@PathVariable Long id) {
        return trainingPlanService.getTrainingPlanById(id);
    }
    @GetMapping("/test")
    public String testEndpoint() {
        return "TrainingPlan Controller is working";
    }
}
