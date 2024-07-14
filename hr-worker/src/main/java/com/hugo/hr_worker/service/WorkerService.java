package com.hugo.hr_worker.service;

import com.hugo.hr_worker.domain.dto.WorkerCreateDto;
import com.hugo.hr_worker.domain.dto.WorkerReadDto;
import com.hugo.hr_worker.domain.exception.WorkerNotFoundException;
import com.hugo.hr_worker.domain.model.Worker;
import com.hugo.hr_worker.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@Service
public class WorkerService {

    @Autowired
    private WorkerRepository workerRepository;

    private final Function<Worker, WorkerReadDto> workerReadDtoMapper =
            worker -> WorkerReadDto.builder()
                    .id(worker.getId())
                    .name(worker.getName())
                    .dailyIncome(worker.getDailyIncome())
                    .build();

    public List<WorkerReadDto> getAll() {
        return workerRepository.findAll()
                .stream()
                .map(workerReadDtoMapper).toList();
    }

    public WorkerReadDto getById(Long id) throws WorkerNotFoundException {
        return workerRepository
                .findById(id)
                .map(workerReadDtoMapper)
                .orElseThrow(() -> new WorkerNotFoundException("Worker not found"));
    }

    public WorkerReadDto create(WorkerCreateDto workerCreateDto) {
        var worker = Worker.builder()
                .name(workerCreateDto.name())
                .dailyIncome(workerCreateDto.dailyIncome())
                .build();

        workerRepository.save(worker);

        return workerReadDtoMapper.apply(worker);
    }
}
