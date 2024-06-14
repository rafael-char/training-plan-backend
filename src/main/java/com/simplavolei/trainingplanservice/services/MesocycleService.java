package com.simplavolei.trainingplanservice.services;

import com.simplavolei.trainingplanservice.models.Mesocycle;
import com.simplavolei.trainingplanservice.repositories.MesocycleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MesocycleService {

    @Autowired
    private MesocycleRepository mesocycleRepository;

    public Mesocycle createMesocycle(Mesocycle mesocycle) {
        return mesocycleRepository.save(mesocycle);
    }

    public Mesocycle updateMesocycle(Long id, Mesocycle mesocycle) {
        Optional<Mesocycle> optionalMesocycle = mesocycleRepository.findById(id);
        if (optionalMesocycle.isPresent()) {
            Mesocycle existingMesocycle = optionalMesocycle.get();
            existingMesocycle.setName(mesocycle.getName());
            existingMesocycle.setDescription(mesocycle.getDescription());
            return mesocycleRepository.save(existingMesocycle);
        } else {
            throw new RuntimeException("Mesocycle not found with id " + id);
        }
    }

    public void deleteMesocycle(Long id) {
        mesocycleRepository.deleteById(id);
    }

    public List<Mesocycle> getAllMesocycles() {
        return mesocycleRepository.findAll();
    }

    public Mesocycle getMesocycleById(Long id) {
        return mesocycleRepository.findById(id).orElse(null);
    }
    public void save(Mesocycle mesocycle) {
        mesocycleRepository.save(mesocycle);
    }
}
