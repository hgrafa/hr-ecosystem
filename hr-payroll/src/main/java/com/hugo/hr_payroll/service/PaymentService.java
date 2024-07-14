package com.hugo.hr_payroll.service;

import com.hugo.hr_payroll.clients.WorkerClient;
import com.hugo.hr_payroll.model.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class PaymentService {

    @Autowired
    private Environment env;

    @Autowired
    private WorkerClient workerClient;

    public Payment getPayment(Long workerId, int days) {
        log.info("Moment: {}, From port: {}", LocalDateTime.now(), env.getProperty("local.server.port"));
        var worker = workerClient.findById(workerId).getBody();

        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}

