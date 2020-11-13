package com.acme.homemade.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.modelmapper.ModelMapper;

@RestController
@RequestMapping("/api")
public class PaymentController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private PaymentController paymentController;
}