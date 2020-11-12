package com.acme.homemade.demo.resource;

import java.util.Date;

public class PaymentResource {
    private Long paymentid;
    private Integer cardnumber;
    private String paymentdetail;
    private Date DateTime;
    private Float total;

    public Long getPaymentid() {
        return paymentid;
    }
    public void setPaymentid(Long paymentid) {
        this.paymentid = paymentid;
    }

    public Integer getCardnumber() {
        return cardnumber;
    }
    public void setCardnumber(Integer cardnumber) {
        this.cardnumber = cardnumber;
    }

    public String getPaymentdetail() {
        return detail;
    }
    public void setPaymentdetail(String paymentdetail) {
        this.detail = paymentdetail;
    }

    public Date getDateTime() {
        return DateTime;
    }
    public void setDateTime(Date DateTime) {
        this.DateTime = DateTime;
    }

    public Float getTotal() {
        return total;
    }
    public void setTotal(Float total) {
        this.total = total;
    }
}