/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderlabz.bankaccountservice.dto;

import java.math.BigDecimal;

/**
 *
 * @author tmashakada email:tmashakada10@gmail.com
 */
public class TransferDto {
    private BigDecimal amount;
   private String accountnumberTo;

    public TransferDto() {
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    

    public String getAccountnumberTo() {
        return accountnumberTo;
    }

    public void setAccountnumberTo(String accountnumberTo) {
        this.accountnumberTo = accountnumberTo;
    }
    
    
}
