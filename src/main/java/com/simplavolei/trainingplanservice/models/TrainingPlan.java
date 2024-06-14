package com.simplavolei.trainingplanservice.models;

import lombok.Data;
import javax.persistence.*;



import java.util.List;

@Entity
@Data
public class TrainingPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "trainingPlan", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Mesocycle> mesocycles;
}
