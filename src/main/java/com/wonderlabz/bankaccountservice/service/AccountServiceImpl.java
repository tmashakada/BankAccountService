/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderlabz.bankaccountservice.service;

import com.wonderlabz.bankaccountservice.consts.AccountConstants;
import com.wonderlabz.bankaccountservice.domain.Account;
import com.wonderlabz.bankaccountservice.domain.AccountType;
import com.wonderlabz.bankaccountservice.domain.Customer;
import com.wonderlabz.bankaccountservice.domain.Transaction;
import com.wonderlabz.bankaccountservice.domain.TransactionType;
import com.wonderlabz.bankaccountservice.exception.AccountException;
import com.wonderlabz.bankaccountservice.exception.EntityAlreadyExistsException;
import com.wonderlabz.bankaccountservice.exception.NoRecordFoundException;
import com.wonderlabz.bankaccountservice.repository.AccountRepository;
import com.wonderlabz.bankaccountservice.repository.CustomerRepository;
import com.wonderlabz.bankaccountservice.repository.TransactionRepository;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tmashakada email:tmashakada10@gmail.com
 */
@Service
public class AccountServiceImpl implements AccountService{
    private  final Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private GenerateAccountNumberService generateAccountNumberService;
     
    @Transactional
    @Override
    public Account openNewAccount(Long customerId, BigDecimal initialDeposit,AccountType accounttype) throws NoRecordFoundException, AccountException, EntityAlreadyExistsException{
       // Account newaccount= null;
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new NoRecordFoundException("Customer was not found for ID: " + customerId,"Customer Not Found"));
             
                   Account account = new Account(
                            generateAccountNumberService.getAccountNumber(accounttype),
                            accounttype,
                            initialDeposit,
                            LocalDateTime.now(),
                            customer);
             if (accounttype.toString().equalsIgnoreCase(AccountType.SAVINGS.toString()) ) {
                  //Creating savings account
                    if(initialDeposit.compareTo(AccountConstants.SAVINGS_ACCOUNT_OPENING_MINI_DEPOSIT)<0)
                       throw new AccountException("Opening Depost is Below Minimu Depost of "
                               +AccountConstants.SAVINGS_ACCOUNT_OPENING_MINI_DEPOSIT);
                   
                   Account alreadyexits= accountRepository.findByCustomerIdAndAccountType(customer.getId(), accounttype);
                  if(alreadyexits!=null)   
                   throw new EntityAlreadyExistsException("Saving Account Already For Customer with  customerid: " + customer.getId(),"Saving Account Already ");
                 Account newaccount=    accountRepository.saveAndFlush(account);
                   Transaction transaction=new Transaction();
                   transaction.setAccount(newaccount);
                   transaction.setDescription("New Savings Account");
                   transaction.setNewaccountbalance(account.getCurrentBalance());
                   transaction.setTranscationtype(TransactionType.CREDIT.toString());
                   transaction.setTransactiondate(LocalDateTime.now());
                   transaction.setTransactionamount(initialDeposit);
                 transactionRepository.saveAndFlush(transaction);
                    
                    
                     return newaccount;
                  
              }else{
                    //Creating Cuurent account
                        Account alreadyexits= accountRepository.findByCustomerIdAndAccountType(customer.getId(), accounttype);
                  if(alreadyexits!=null)   
                   throw new EntityAlreadyExistsException("Current Account Already For Customer with  customerid: " + customer.getId(),"Current Account Already ");                    
                
                  Account     newaccount=         accountRepository.saveAndFlush(account);
                   Transaction transaction=new Transaction();
                   transaction.setAccount(newaccount);
                   transaction.setDescription("New Current Account");
                   transaction.setNewaccountbalance(account.getCurrentBalance());
                   transaction.setTranscationtype(TransactionType.CREDIT.toString());
                   transaction.setTransactiondate(LocalDateTime.now());
                   transaction.setTransactionamount(initialDeposit);
                   transactionRepository.saveAndFlush(transaction);
                   return newaccount;  
              }
         
       
    }

    @Override
    public Account getAccountByAccountNumber(String accountnumber) throws NoRecordFoundException {
        Account account = accountRepository.findByAccountNumber(accountnumber);
            if(account==null) {
                        log.warn("accountRepository.findByAccountNumber: could not find account with accountnumber: " + accountnumber);
			throw new NoRecordFoundException("Could not find account with accountnumber " + accountnumber,"Account Not Found");
            }
        return account;
    }

    @Override
    public List<Account> getAllAccounts() {
         List<Account> accountlist = accountRepository.findAll();
         log.debug("Found " + accountlist.size() + " account(s).");
      
      return accountlist;
    }

    @Override
    public List<Account> getAccountByType(AccountType accounttype) {
          List<Account> accountlist = accountRepository.findByAccountType(accounttype);
           log.debug("Found " + accountlist.size() + " account(s).");
        return accountlist;
    }

    @Override
    public BigDecimal getAccountBalance(String accountnumber) throws NoRecordFoundException {
         Account account = accountRepository.findByAccountNumber(accountnumber);
            if(account==null) {
                        log.warn("accountRepository.findByAccountNumber: could not find account with accountnumber: " + accountnumber);
			throw new NoRecordFoundException("Could not find account with accountnumber " + accountnumber,"Account Not Found");
            }
        return account.getCurrentBalance();
    }
}
