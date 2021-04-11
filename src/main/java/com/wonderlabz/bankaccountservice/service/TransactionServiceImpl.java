/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderlabz.bankaccountservice.service;

import com.wonderlabz.bankaccountservice.domain.Transaction;
import com.wonderlabz.bankaccountservice.exception.BankAccountOperationException;
import com.wonderlabz.bankaccountservice.exception.NoRecordFoundException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author tmashakada email:tmashakada10@gmail.com
 */
public class TransactionServiceImpl  implements TransactionService{

    @Override
    public Transaction deposit(String accountNumber, BigDecimal amount) throws NoRecordFoundException, BankAccountOperationException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Transaction withdraw(String accountNumber, BigDecimal amount) throws NoRecordFoundException, BankAccountOperationException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Transaction transfer(String accountNumberFrom, String accountNumberTo, BigDecimal amount) throws NoRecordFoundException, BankAccountOperationException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Transaction> getAllTransaction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Transaction getTransactionsByTransactionId(long transactionid) throws NoRecordFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Transaction> getAllTransactionByDateRange(LocalDate startdate, LocalDate enddate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Transaction> getTransactionByAcountNumber(String accountNumber) throws NoRecordFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Transaction> getTransactionByAcountNumberByDate(String accountNumber, LocalDate startdate, LocalDate enddate) throws NoRecordFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
