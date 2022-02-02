package com.github.hugodutra.hrpayroll.resources;

import com.github.hugodutra.hrpayroll.entities.Payment;
import com.github.hugodutra.hrpayroll.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payments")
public class PaymentResource {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/{workerId}/days/{days}")
    private ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days){
        Payment payment = paymentService.getPayment(workerId,days);
        return ResponseEntity.ok(payment);
    }
}
