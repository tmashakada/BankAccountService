/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderlabz.bankaccountservice.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author tmashakada email:tmashakada10@gmail.com
 */
@Entity
@Table(name = "transactionhistory")
public class Transaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transactionid")
    private Long transactionId;
    private String description;
    @Column(nullable = false,precision = 18, scale = 2)
    private BigDecimal transactionamount;
    private String transcationtype;
    
     @Column(name = "balance", nullable = false, precision = 18, scale = 2)
     private BigDecimal newaccountbalance;
     @Column( nullable = false)
     private LocalDateTime transactiondate;
        
     @ManyToOne(cascade = CascadeType.MERGE)
     @JoinColumn(name = "account_id",nullable = false)
     private Account account;

    public Transaction() {
    }

    public Transaction(String description, BigDecimal transactionamount, String transcationtype, BigDecimal newaccountbalance, LocalDateTime transactiondate, Account account) {
        this.description = description;
        this.transactionamount = transactionamount;
        this.transcationtype = transcationtype;
        this.newaccountbalance = newaccountbalance;
        this.transactiondate = transactiondate;
        this.account = account;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getTransactionamount() {
        return transactionamount;
    }

    public void setTransactionamount(BigDecimal transactionamount) {
        this.transactionamount = transactionamount;
    }

    public String getTranscationtype() {
        return transcationtype;
    }

    public void setTranscationtype(String transcationtype) {
        this.transcationtype = transcationtype;
    }

    public BigDecimal getNewaccountbalance() {
        return newaccountbalance;
    }

    public void setNewaccountbalance(BigDecimal newaccountbalance) {
        this.newaccountbalance = newaccountbalance;
    }

    public LocalDateTime getTransactiondate() {
        return transactiondate;
    }

    public void setTransactiondate(LocalDateTime transactiondate) {
        this.transactiondate = transactiondate;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
     
     
}
