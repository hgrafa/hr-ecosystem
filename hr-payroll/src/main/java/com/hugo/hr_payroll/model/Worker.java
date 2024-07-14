package com.hugo.hr_payroll.model;

import lombok.*;

@Getter @Setter @Builder
@AllArgsConstructor @NoArgsConstructor
public class Worker {
    private Long id;
    private String name;
    private Double dailyIncome;
}
