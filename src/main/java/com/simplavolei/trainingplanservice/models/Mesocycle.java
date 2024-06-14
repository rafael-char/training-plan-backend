package com.simplavolei.trainingplanservice.models;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Mesocycle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "training_plan_id")
    private TrainingPlan trainingPlan;

    @OneToMany(mappedBy = "mesocycle", cascade = CascadeType.ALL)
    private List<Microcycle> microcycles;
}
