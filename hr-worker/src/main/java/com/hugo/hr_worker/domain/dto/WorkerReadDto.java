package com.hugo.hr_worker.domain.dto;

import lombok.Builder;

@Builder
public record WorkerReadDto(Long id, String name, Double dailyIncome) {
}
