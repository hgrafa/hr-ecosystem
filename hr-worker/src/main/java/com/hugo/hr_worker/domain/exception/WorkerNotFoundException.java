package com.hugo.hr_worker.domain.exception;

public class WorkerNotFoundException extends Exception {
    public WorkerNotFoundException() {
        super("Worker not found");
    }

    public WorkerNotFoundException(String message) {
        super(message);
    }
}
