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
public class DepositWithdrawDto {
    private BigDecimal  amount;

    public DepositWithdrawDto() {
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }
    
}
