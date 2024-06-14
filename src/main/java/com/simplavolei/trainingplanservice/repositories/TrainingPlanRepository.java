package com.simplavolei.trainingplanservice.repositories;

import com.simplavolei.trainingplanservice.models.TrainingPlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingPlanRepository extends JpaRepository<TrainingPlan, Long> {
}
