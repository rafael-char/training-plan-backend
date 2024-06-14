package com.simplavolei.trainingplanservice.services;

import com.simplavolei.trainingplanservice.models.TrainingPlan;
import com.simplavolei.trainingplanservice.repositories.TrainingPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainingPlanService {

    @Autowired
    private TrainingPlanRepository trainingPlanRepository;

    public TrainingPlan createTrainingPlan(TrainingPlan trainingPlan) {
        return trainingPlanRepository.save(trainingPlan);
    }

    public TrainingPlan updateTrainingPlan(Long id, TrainingPlan trainingPlan) {
        Optional<TrainingPlan> optionalTrainingPlan = trainingPlanRepository.findById(id);
        if (optionalTrainingPlan.isPresent()) {
            TrainingPlan existingTrainingPlan = optionalTrainingPlan.get();
            existingTrainingPlan.setName(trainingPlan.getName());
            existingTrainingPlan.setMesocycles(trainingPlan.getMesocycles());
            return trainingPlanRepository.save(existingTrainingPlan);
        } else {
            throw new RuntimeException("TrainingPlan not found with id " + id);
        }
    }

    public void deleteTrainingPlan(Long id) {
        trainingPlanRepository.deleteById(id);
    }

    public List<TrainingPlan> getAllTrainingPlans() {
        return trainingPlanRepository.findAll();
    }

    public TrainingPlan getTrainingPlanById(Long id) {
        return trainingPlanRepository.findById(id).orElse(null);
    }
}

