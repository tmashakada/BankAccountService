/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderlabz.bankaccountservice.consts;

import java.math.BigDecimal;

/**
 *
 * @author tmashakada email:tmashakada10@gmail.com
 */
public class AccountConstants {
    public static final BigDecimal SAVINGS_ACCOUNT_OPENING_MINI_DEPOSIT = new BigDecimal("1000.00");
    public static final BigDecimal SAVINGS_ACCOUNT_MINIMUM_BALANCE = new BigDecimal("1000.00");
    public static final BigDecimal CURRENT_ACCOUNT_OVERDRAFT_LIMIT = new BigDecimal("100000.00");
    public static final int CURRENT_ACCOUNT = 200;
    public static final int SAVING_ACCOUNT = 300;
}
