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
public class AccountCreationDto {
     private Long  customerid;
     private String accounttype;
     private BigDecimal initialdeposit;

    public AccountCreationDto() {
    }

    public Long getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Long customerid) {
        this.customerid = customerid;
    }

    public String getAccounttype() {
        return accounttype;
    }

    public void setAccounttype(String accounttype) {
        this.accounttype = accounttype;
    }

    public BigDecimal getInitialdeposit() {
        return initialdeposit;
    }

    public void setInitialdeposit(BigDecimal initialdeposit) {
        this.initialdeposit = initialdeposit;
    }
     
}
