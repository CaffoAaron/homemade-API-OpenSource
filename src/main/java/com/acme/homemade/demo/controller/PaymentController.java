package com.acme.homemade.demo.controller;

import com.acme.homemade.demo.domain.model.Payment;
import com.acme.homemade.demo.domain.model.Publication;
import com.acme.homemade.demo.domain.service.PaymentService;
import com.acme.homemade.demo.resource.PaymentResource;
import com.acme.homemade.demo.resource.PublicationResource;
import com.acme.homemade.demo.resource.SavePaymentResource;
import com.acme.homemade.demo.resource.SavePublicationResource;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.modelmapper.ModelMapper;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class PaymentController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private PaymentService paymentService;

    @Operation(summary = "Get payments", description = "Get All UserNoChef by userNoId", tags = {"payments"})
    @GetMapping("/payments/users/{userId}")
    public Page<PaymentResource> getAllPaymentsByUserId(@PathVariable Long userId, Pageable pageable){
        Page<Payment> paymentPage = paymentService.getAllPaymentByUserNoChefId(userId, pageable);
        List<PaymentResource> resource= paymentPage
                .getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resource, pageable, resource.size());
    }
    @Operation(summary = "Get payments", description = "Get All Payments", tags = {"payments"})
    @GetMapping("/payments")
    public Page<PaymentResource> getAllPayments (Pageable pageable){
        Page<Payment> paymentPage = paymentService.getAllPayment(pageable);
        List<PaymentResource> resource= paymentPage
                .getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resource, pageable, resource.size());
    }
    @Operation(summary = "Create payments", description = "Create a new payments", tags = {"payments"})
    @PostMapping("/payments/users/{userId}")
    public PaymentResource createPublication(@PathVariable Long userId, @Valid @RequestBody SavePaymentResource resource){
        return convertToResource(paymentService.createPayment(userId, convertToEntity(resource)));
    }
    @Operation(summary = "Update payments", description = "Update payments for given Id", tags = {"payments"})
    @PutMapping("/payments/{paymentId}/users/{userId}")
    public PaymentResource updatePublication(@PathVariable(value = "paymentId") Long paymentId,
                                                 @PathVariable(value = "userId") Long userId,
                                                 @Valid @RequestBody SavePaymentResource resource){
        return convertToResource(paymentService.updatePayment(userId, paymentId, convertToEntity(resource)));
    }
    @Operation(summary = "Delete payments", description = "Delete payments with given Id", tags = {"payments"})
    @DeleteMapping("/payments/{paymentId}/users/{userId}")
    public ResponseEntity<?> deletePayment(@PathVariable(value = "paymentId") Long paymentId,
                                               @PathVariable(value = "userId") Long userId){
        return paymentService.deletePayment(userId, paymentId);
    }
    private Payment convertToEntity(SavePaymentResource resource) {
        return mapper.map(resource, Payment.class);
    }
    private PaymentResource convertToResource(Payment entity) {
        return mapper.map(entity, PaymentResource.class);
    }
}