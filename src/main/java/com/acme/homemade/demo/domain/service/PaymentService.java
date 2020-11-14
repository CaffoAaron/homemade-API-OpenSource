package com.acme.homemade.demo.domain.service;

import com.acme.homemade.demo.domain.model.Payment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface PaymentService {
    Payment getPaymentById (Long paymentId);

    Page<Payment> getAllPaymentByUserNoChefId(Long userId, Pageable pageable);

    Page<Payment> getAllPayment (Pageable pageable);

    Payment getPaymentByIdAndUserNoChefId (Long userId, Long paymentId);

    Payment createPayment(Long userId, Payment payment);

    Payment updatePayment(Long userId, Long paymentId ,Payment payment);

    ResponseEntity<?> deletePayment (Long userId, Long paymentId);
}