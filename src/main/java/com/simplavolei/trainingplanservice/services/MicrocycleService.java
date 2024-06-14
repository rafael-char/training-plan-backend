package com.simplavolei.trainingplanservice.services;

import com.simplavolei.trainingplanservice.models.Microcycle;
import com.simplavolei.trainingplanservice.repositories.MicrocycleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MicrocycleService {

    @Autowired
    private MicrocycleRepository microcycleRepository;

    public Microcycle createMicrocycle(Microcycle microcycle) {
        return microcycleRepository.save(microcycle);
    }

    public Microcycle updateMicrocycle(Long id, Microcycle microcycle) {
        Optional<Microcycle> optionalMicrocycle = microcycleRepository.findById(id);
        if (optionalMicrocycle.isPresent()) {
            Microcycle existingMicrocycle = optionalMicrocycle.get();
            existingMicrocycle.setName(microcycle.getName());
            return microcycleRepository.save(existingMicrocycle);
        } else {
            throw new RuntimeException("Microcycle not found with id " + id);
        }
    }

    public void deleteMicrocycle(Long id) {
        microcycleRepository.deleteById(id);
    }

    public List<Microcycle> getAllMicrocycles() {
        return microcycleRepository.findAll();
    }

    public Microcycle getMicrocycleById(Long id) {
        return microcycleRepository.findById(id).orElse(null);
    }
}
