package com.acme.homemade.demo.resource;

import java.util.Date;

public class PaymentResource {
    private Long id;
    private Integer cardNumber;
    private String cardName;
    private String paymentDetail;
    private Date dateTime;
    private Float total;

    public Long getId() {
        return id;
    }

    public PaymentResource setId(Long id) {
        this.id = id;
        return this;
    }

    public Integer getCardNumber() {
        return cardNumber;
    }

    public PaymentResource setCardNumber(Integer cardNumber) {
        this.cardNumber = cardNumber;
        return this;
    }

    public String getPaymentDetail() {
        return paymentDetail;
    }

    public PaymentResource setPaymentDetail(String paymentDetail) {
        this.paymentDetail = paymentDetail;
        return this;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public PaymentResource setDateTime(Date dateTime) {
        this.dateTime = dateTime;
        return this;
    }

    public Float getTotal() {
        return total;
    }

    public PaymentResource setTotal(Float total) {
        this.total = total;
        return this;
    }
    public String getCardName() {
        return cardName;
    }

    public PaymentResource setCardName(String cardName) {
        this.cardName = cardName;
        return this;
    }
}