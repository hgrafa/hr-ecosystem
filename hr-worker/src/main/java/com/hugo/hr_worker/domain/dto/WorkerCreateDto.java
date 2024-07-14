package com.hugo.hr_worker.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record WorkerCreateDto(
        @NotBlank(message = "Name is required")
        @Size(min = 1, max = 255, message = "Name must be between 1 and 255 characters")
        String name,

        @NotNull(message = "Daily income is required")
        @Positive(message = "Daily income must be positive")
        Double dailyIncome
) {
}
