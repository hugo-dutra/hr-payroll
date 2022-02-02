package com.github.hugodutra.hrpayroll.services;

import com.github.hugodutra.hrpayroll.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(Long workerId, int days){
        return new Payment("Bob",200.0,days);
    }

}
