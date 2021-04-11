/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderlabz.bankaccountservice.controller;

import com.wonderlabz.bankaccountservice.domain.Account;
import com.wonderlabz.bankaccountservice.domain.AccountType;
import com.wonderlabz.bankaccountservice.dto.AccountCreationDto;
import com.wonderlabz.bankaccountservice.dto.AccountDto;
import com.wonderlabz.bankaccountservice.exception.AccountException;
import com.wonderlabz.bankaccountservice.exception.EntityAlreadyExistsException;
import com.wonderlabz.bankaccountservice.exception.NoRecordFoundException;
import com.wonderlabz.bankaccountservice.mapper.AccountMapper;
import com.wonderlabz.bankaccountservice.service.AccountServiceImpl;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author tmashakada email:tmashakada10@gmail.com
 */
@RestController
@RequestMapping("/api")
public class AccountController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private AccountServiceImpl accountServiceImpl;
    
    /**
     * 
     * @param acountCreationDto
     * @return
     * @throws AccountException 
     */
    @PostMapping(value="/account",consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<AccountDto>   createAccount(@Valid @RequestBody AccountCreationDto acountCreationDto) throws AccountException, NoRecordFoundException, EntityAlreadyExistsException {
        
        log.info(" "+acountCreationDto.getAccounttype()+acountCreationDto.getCustomerid()+" "+acountCreationDto.getInitialdeposit());
       
        AccountType accountType =AccountType.valueOf(acountCreationDto.getAccounttype().toUpperCase());
       
      
      
         AccountDto accountDto=AccountMapper.INSTANCE.toAccountDto(accountServiceImpl.openNewAccount(acountCreationDto.getCustomerid(),acountCreationDto.getInitialdeposit(),accountType));
                
        return new ResponseEntity<>(accountDto, HttpStatus.CREATED);
    }
    /**
     * 
     * @return 
     */
    @GetMapping(value="/accounts",produces= MediaType.APPLICATION_JSON_VALUE) 
    public  ResponseEntity<List<Account>>  getAllAccounts(){
     List<Account> listaccounts=   accountServiceImpl.getAllAccounts();
    return new ResponseEntity<>(listaccounts, HttpStatus.OK);
        
    }
    /**
     * 
     * @param accountype
     * @return 
     */
    @GetMapping(value="/accounts/{accountype}",produces = MediaType.APPLICATION_JSON_VALUE) 
    public  ResponseEntity<List<Account>>  getAccountsByType(@Valid @PathVariable("accountype") String accountype){
        
         AccountType accountType =AccountType.valueOf(accountype.toUpperCase());
         List<Account> listaccounts=   accountServiceImpl.getAccountByType(accountType);
         
    return new ResponseEntity<>(listaccounts, HttpStatus.OK);
        
    }
    
    /**
     * 
     * @param accountnumber
     * @return
     * @throws NoRecordFoundException 
     */
    @GetMapping(value="/account/{accountnumber}",produces = MediaType.APPLICATION_JSON_VALUE) 
    public  ResponseEntity<Account>  getAccountByAccountNumber(@Valid @PathVariable("accountnumber") String accountnumber) throws NoRecordFoundException{
        
      
         Account account=   accountServiceImpl.getAccountByAccountNumber(accountnumber);
         
    return new ResponseEntity<>(account, HttpStatus.OK);
        
    }
    
    /**
     * 
     * @param accountnumber
     * @return
     * @throws NoRecordFoundException 
     */
    @GetMapping(value="/accountbalance/{accountnumber}",produces = MediaType.APPLICATION_JSON_VALUE) 
    public  ResponseEntity<BigDecimal>  getAccountBalance(@Valid @PathVariable("accountnumber") String accountnumber) throws NoRecordFoundException{
        
      
       BigDecimal balance=   accountServiceImpl.getAccountBalance(accountnumber);
         
    return new ResponseEntity<>( balance, HttpStatus.OK);
        
    }
    
}
