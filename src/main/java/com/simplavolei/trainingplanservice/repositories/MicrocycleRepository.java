package com.simplavolei.trainingplanservice.repositories;

import com.simplavolei.trainingplanservice.models.Microcycle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MicrocycleRepository extends JpaRepository<Microcycle, Long> {
}