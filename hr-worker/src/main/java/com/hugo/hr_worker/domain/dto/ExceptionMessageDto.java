package com.hugo.hr_worker.domain.dto;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public record ExceptionMessageDto(
        List<String> errors,
        String path,
        LocalDateTime moment
) {

}
