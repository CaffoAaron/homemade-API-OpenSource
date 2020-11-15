package com.acme.homemade.demo.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "Payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long cardNumber;

    @NotNull
    private String cardName;

    @NotNull
    private String paymentDetail;

    @NotNull
    private Date dateTime;

    @NotNull
    private Float total;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userNoChef_id", nullable = false)
    @JsonIgnore
    private UserNoChef userNoChef;

    public Long getId() {
        return id;
    }

    public Payment setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getCardNumber() {
        return cardNumber;
    }

    public Payment setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
        return this;
    }

    public String getCardName() {
        return cardName;
    }

    public Payment setCardName(String cardName) {
        this.cardName = cardName;
        return this;
    }

    public String getPaymentDetail() {
        return paymentDetail;
    }

    public Payment setPaymentDetail(String paymentDetail) {
        this.paymentDetail = paymentDetail;
        return this;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public Payment setDateTime(Date dateTime) {
        this.dateTime = dateTime;
        return this;
    }

    public Float getTotal() {
        return total;
    }

    public Payment setTotal(Float total) {
        this.total = total;
        return this;
    }

    public UserNoChef getUserNoChef() {
        return userNoChef;
    }

    public Payment setUserNoChef(UserNoChef userNoChef) {
        this.userNoChef = userNoChef;
        return this;
    }
}