package com.hugo.hr_worker.controller;

import com.hugo.hr_worker.domain.dto.ExceptionMessageDto;
import com.hugo.hr_worker.domain.exception.WorkerNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
public class WorkerExceptionHandler {

    @ExceptionHandler(WorkerNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ExceptionMessageDto> handleWorkerNotFoundException(
            WorkerNotFoundException exception,
            HttpServletRequest request
    ) {
        var message = ExceptionMessageDto.builder()
                .path(request.getRequestURI())
                .moment(LocalDateTime.now())
                .errors(List.of(exception.getMessage()))
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }


}
