package com.hugo.hr_worker.domain.model;

import jakarta.persistence.*;
import lombok.*;


@Getter @Setter @Builder
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "workers")
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double dailyIncome;
}
