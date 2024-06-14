package com.simplavolei.trainingplanservice.controllers;

import com.simplavolei.trainingplanservice.models.Mesocycle;
import com.simplavolei.trainingplanservice.services.MesocycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/mesocycles")
public class MesocycleController {

    @Autowired
    private MesocycleService mesocycleService;

   

    @PostMapping
    public String createMesocycle(Mesocycle mesocycle) {
        mesocycleService.save(mesocycle);
        return "redirect:/mesocycles";
    }

    @PutMapping("/{id}")
    public Mesocycle updateMesocycle(@PathVariable Long id, @RequestBody Mesocycle mesocycle) {
        return mesocycleService.updateMesocycle(id, mesocycle);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMesocycle(@PathVariable Long id) {
        mesocycleService.deleteMesocycle(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<Mesocycle> getAllMesocycles() {
        return mesocycleService.getAllMesocycles();
    }

    @GetMapping("/{id}")
    public Mesocycle getMesocycleById(@PathVariable Long id) {
        return mesocycleService.getMesocycleById(id);
    }
    @GetMapping("/mesocycles/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        Mesocycle mesocycle = mesocycleService.getMesocycleById(id);
        model.addAttribute("mesocycle", mesocycle);
        return "editMesocycle"; // nombre de la vista Thymeleaf para editar
    }

}

