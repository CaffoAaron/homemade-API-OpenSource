package com.acme.homemade.demo.resource;

import com.sun.istack.NotNull;
import java.util.Date;

public class SavePaymentResource {
    private Date DateTime;
    private Integer paymentid;
    private String paymentdetail;
    public Date getDate() {
        return DateTime;
    }

    public SavePaymentResource setDate(Date DateTime) {
        this.DateTime = DateTime;
        return this;
    }

    public String getPaymentDetail() {
        return paymentdetail;
    }

    public SavePaymentResource setText(String paymentdetail) {
        this.paymentdetail = paymentdetail;
        return this;
    }

    public Integer getPaymentid() {
        return paymentid;
    }

    public SavePaymentResource setPaymentId(Integer paymentid) {
        this.paymentid = paymentid;
        return this;
    }
}