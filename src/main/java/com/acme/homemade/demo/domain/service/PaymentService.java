package com.acme.homemade.demo.domain.service;

public interface PaymentService {
    Payment getPaymentById (Long paymentId);

    Page<Payment> getAllPaymentByUserNoChefId(Long userId, Pageable pageable);

    Page<Payment> getAllPayment (Pageable pageable);

    Payment getPaymentByIdAndUserNoChefId (Long userId, Long paymentId);

    Payment createPayment(Long userId, Payment payment);

    Payment updatePayment(Long userId, Long paymentId ,Payment payment);

    ResponseEntity<?>  deletePayment (Long userId, Long paymentId);
}
