/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderlabz.bankaccountservice.service;

import com.wonderlabz.bankaccountservice.domain.Account;
import com.wonderlabz.bankaccountservice.domain.AccountType;
import com.wonderlabz.bankaccountservice.exception.AccountException;
import com.wonderlabz.bankaccountservice.exception.NoRecordFoundException;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author tmashakada email:tmashakada10@gmail.com
 */
public interface AccountService {
     Account openNewAccount(Account account)throws AccountException;
     Account getAccountByAccountNumber(String accountnumber)throws NoRecordFoundException;
     List<Account> getAllAccounts();
     List<Account> getAccountByType(AccountType accounttype);
     BigDecimal getAccountBalnce(String accountnumber)throws NoRecordFoundException;
}
