package com.acme.homemade.demo.service;

import com.acme.homemade.demo.domain.model.Payment;
import com.acme.homemade.demo.domain.repository.PaymentRepository;
import com.acme.homemade.demo.domain.repository.UserNoChefRepository;
import com.acme.homemade.demo.domain.service.PaymentService;
import com.acme.homemade.demo.execption.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private UserNoChefRepository userNoChefRepository;

    @Override
    public Payment getPaymentById(Long paymentId) {
        return paymentRepository.findById(paymentId).orElseThrow(() -> new ResourceNotFoundException("Payment", "Id", paymentId));
    }

    @Override
    public Page<Payment> getAllPaymentByUserNoChefId(Long userNoChefId, Pageable pageable) {
        return paymentRepository.findByUserNoChefId(userNoChefId, pageable);
    }

    @Override
    public Page<Payment> getAllPayment(Pageable pageable) {
        return paymentRepository.findAll(pageable);
    }

    @Override
    public Payment getPaymentByIdAndUserNoChefId(Long userNoChefId, Long paymentId) {
        return paymentRepository.findByIdAndUserNoChefId(paymentId, userNoChefId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Payment not found with Id " + paymentId +
                                " and User " + userNoChefId));
    }

    @Override
    public Payment createPayment(Long userId, Payment payment) {
        return userNoChefRepository.findById(userId).map( userNoChef -> {
            payment.setUserNoChef(userNoChef);
            return paymentRepository.save(payment);
        }).orElseThrow(() -> new ResourceNotFoundException(
                "UserNoChefId", "Id", userId));
    }

    @Override
    public Payment updatePayment(Long userId, Long paymentId, Payment payment) {
        if (!userNoChefRepository.existsById(userId))
            throw new ResourceNotFoundException("User", "Id", userId);
        return paymentRepository.findById(paymentId).map(payment1 -> {
            payment1.setCardName(payment.getCardName());
            payment1.setCardNumber(payment.getCardNumber());
            payment1.setDateTime(payment.getDateTime());
            payment1.setTotal(payment.getTotal());
            return paymentRepository.save(payment1);
        }).orElseThrow(() -> new ResourceNotFoundException("Payment", "Id", paymentId));
    }

    @Override
    public ResponseEntity<?> deletePayment(Long userId, Long paymentId) {
        if (!userNoChefRepository.existsById(userId))
            throw new ResourceNotFoundException("User", "Id", userId);
        return paymentRepository.findById(paymentId).map(payment -> {
            paymentRepository.delete(payment);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Payment", "Id", paymentId));
    }
}
