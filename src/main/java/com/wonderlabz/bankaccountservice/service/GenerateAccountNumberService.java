/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderlabz.bankaccountservice.service;

import com.wonderlabz.bankaccountservice.consts.AccountConstants;
import com.wonderlabz.bankaccountservice.domain.Account;
import com.wonderlabz.bankaccountservice.domain.AccountType;
import com.wonderlabz.bankaccountservice.repository.AccountRepository;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tmashakada email:tmashakada10@gmail.com
 */
@Service
public class GenerateAccountNumberService {
       @Autowired
       private  AccountRepository accountRepository;
       private static final int RANDOM_UPPER_BOUND = 10;
          
       private static final Random rand = new Random();
       public String getAccountNumber(Account account){
          String firstpart=new SimpleDateFormat("yyMMdd").format(Calendar.getInstance().getTime());
          String lastpart=new SimpleDateFormat("mm").format(Calendar.getInstance().getTime());
         
          StringBuilder accountNumber = new StringBuilder();
          if (Objects.equals(account.getAccountType(), AccountType.SAVINGS)) {
                accountNumber.append(AccountConstants.SAVING_ACCOUNT); 
          }else{
               accountNumber.append(AccountConstants.CURRENT_ACCOUNT);
          }
         accountNumber.append(firstpart);
        // Concatenate random numbers (0-9) to form an account number
        for (int i = 0; i < 4; i++) {
            accountNumber.append(rand.nextInt(RANDOM_UPPER_BOUND));
        }
          accountNumber.append(lastpart);
        // If the generated account number is in use, try again recursively
        if (accountRepository.existsByAccountNumber(accountNumber.toString())) {
            return getAccountNumber(account);
        }
        
        return   accountNumber.toString();
        
    }
}
