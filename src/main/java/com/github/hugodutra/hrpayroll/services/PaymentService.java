package com.github.hugodutra.hrpayroll.services;

import com.github.hugodutra.hrpayroll.entities.Payment;
import com.github.hugodutra.hrpayroll.entities.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${hr-worker.host}")
    private String WORKER_HOST;

    public Payment getPayment(Long workerId, int days) {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("id", workerId.toString());
        Worker worker = restTemplate.getForObject(WORKER_HOST + "/api/workers/{id}", Worker.class, uriVariables);
        return new Payment(worker.getName(), worker.getDaylyIncome(), days);
    }

}
