/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderlabz.bankaccountservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *
 * @author tmashakada email:tmashakada10@gmail.com
 */
public class DepositWithdrawMsgDto {
    private String message;
    private String accountnumber;
    private BigDecimal availablebalance;
    private long transactionnumber;
  
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime transactiondate;
    public DepositWithdrawMsgDto() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(String accountnumber) {
        this.accountnumber = accountnumber;
    }

    public BigDecimal getAvailablebalance() {
        return availablebalance;
    }

    public void setAvailablebalance(BigDecimal availablebalance) {
        this.availablebalance = availablebalance;
    }

    public long getTransactionnumber() {
        return transactionnumber;
    }

    public void setTransactionnumber(long transactionnumber) {
        this.transactionnumber = transactionnumber;
    }

    public LocalDateTime getTransactiondate() {
        return transactiondate;
    }

    public void setTransactiondate(LocalDateTime transactiondate) {
        this.transactiondate = transactiondate;
    }

   
    
}
