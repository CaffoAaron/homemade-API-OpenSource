package com.acme.homemade.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PaymentController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private PaymentService paymentService;
}