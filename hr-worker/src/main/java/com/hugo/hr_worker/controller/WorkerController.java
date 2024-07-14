package com.hugo.hr_worker.controller;

import com.hugo.hr_worker.domain.dto.WorkerCreateDto;
import com.hugo.hr_worker.domain.dto.WorkerReadDto;
import com.hugo.hr_worker.domain.exception.WorkerNotFoundException;
import com.hugo.hr_worker.service.WorkerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("workers")
public class WorkerController {

    @Autowired
    private WorkerService workerService;

    @GetMapping
    public ResponseEntity<List<WorkerReadDto>> getAll() {
        var workers = workerService.getAll();
        return ResponseEntity.ok(workers);
    }

    @GetMapping("{id}")
    public ResponseEntity<WorkerReadDto> getById(
            @PathVariable Long id
    ) throws WorkerNotFoundException {
        var worker = workerService.getById(id);
        return ResponseEntity.ok(worker);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<WorkerReadDto> create(
            @Valid @RequestBody WorkerCreateDto workerCreateDto,
            UriComponentsBuilder uriBuilder
    ) {
        var createdWorker = workerService.create(workerCreateDto);

        var uri = uriBuilder.path("workers/{id}")
                .buildAndExpand(createdWorker.id())
                .toUri();

        return ResponseEntity.created(uri).body(createdWorker);
    }

}
