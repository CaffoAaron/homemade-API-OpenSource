package com.acme.homemade.demo.domain.service;

public interface PaymentService {
    Payment getPaymentById (Long paymentId);

    Page<Payment> getAllPaymentByUserNoChefId(Long userNoChefId, Pageable pageable);

    Page<Payment> getAllPayment (Pageable pageable);

    Payment getPaymentByIdAndUserNoChefId (Long userNoChefId, Long paymentId);

    Payment createPayment(Long userNoChefId, Payment payment);

    Payment updatePayment(Long userNoChefId, Long paymentId ,Payment payment);

    ResponseEntity<?>  deletePayment (Long userNoChefId, Long paymentId);
}
