package com.github.hugodutra.hrpayroll.services;

import com.github.hugodutra.hrpayroll.entities.Payment;
import com.github.hugodutra.hrpayroll.entities.Worker;
import com.github.hugodutra.hrpayroll.feignclients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient workerFeignClient;

    public Payment getPayment(Long workerId, int days) { 
        Worker worker = workerFeignClient.findById(workerId).getBody();
        return new Payment(worker.getName(), worker.getDaylyIncome(), days);
    }

}
