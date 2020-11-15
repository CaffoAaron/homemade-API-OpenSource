package com.acme.homemade.demo.resource;

import java.util.Date;

public class SavePaymentResource {
    private Integer cardNumber;
    private String cardName;
    private String paymentDetail;
    private Date dateTime;
    private Float total;

    public Integer getCardNumber() {
        return cardNumber;
    }

    public SavePaymentResource setCardNumber(Integer cardNumber) {
        this.cardNumber = cardNumber;
        return this;
    }

    public String getPaymentDetail() {
        return paymentDetail;
    }

    public SavePaymentResource setPaymentDetail(String paymentDetail) {
        this.paymentDetail = paymentDetail;
        return this;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public SavePaymentResource setDateTime(Date dateTime) {
        this.dateTime = dateTime;
        return this;
    }

    public Float getTotal() {
        return total;
    }

    public SavePaymentResource setTotal(Float total) {
        this.total = total;
        return this;
    }
    public String getCardName() {
        return cardName;
    }

    public SavePaymentResource setCardName(String cardName) {
        this.cardName = cardName;
        return this;
    }
}
