/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderlabz.bankaccountservice.service;

import com.wonderlabz.bankaccountservice.consts.AccountConstants;
import com.wonderlabz.bankaccountservice.domain.Account;
import com.wonderlabz.bankaccountservice.domain.AccountType;
import com.wonderlabz.bankaccountservice.domain.OperationType;
import com.wonderlabz.bankaccountservice.domain.Transaction;
import com.wonderlabz.bankaccountservice.domain.TransactionType;
import com.wonderlabz.bankaccountservice.exception.BankAccountOperationException;
import com.wonderlabz.bankaccountservice.exception.NoRecordFoundException;
import com.wonderlabz.bankaccountservice.repository.AccountRepository;
import com.wonderlabz.bankaccountservice.repository.TransactionRepository;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 *
 * @author tmashakada email:tmashakada10@gmail.com
 */
@Service
public class TransactionServiceImpl  implements TransactionService{
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Override
    public Transaction deposit(String accountNumber, BigDecimal amount) throws NoRecordFoundException, BankAccountOperationException {
         Account account = accountRepository.findByAccountNumber(accountNumber);
          
           if ( account==null) 
                throw new NoRecordFoundException("Could Not Find Account With AccountNumber: "+accountNumber,"Account Number Not Found");
            BigDecimal bal=account.getCurrentBalance();
           System.out.println("accountNumber2"+" "+accountNumber);
           if ( amount.compareTo(BigDecimal.ZERO) <= 0) 
                throw new BankAccountOperationException("Invalid Deposit Amount");
               BigDecimal newcurrentBalance= account.getCurrentBalance().add(amount);
               account.setCurrentBalance(newcurrentBalance);
               accountRepository.saveAndFlush( account);
                Transaction transcation =new Transaction();
                transcation.setAccount(account);
                transcation.setDescription(OperationType.DEPOSIT.toString());
                transcation.setTranscationtype(TransactionType.CREDIT.toString());
                transcation.setTransactionamount(amount);
                transcation.setTransactiondate(LocalDateTime.now());
                transcation.setNewaccountbalance(newcurrentBalance);
                
                
        
        return  transactionRepository.saveAndFlush(transcation);
    }

    @Override
    public Transaction withdraw(String accountNumber, BigDecimal amount) throws NoRecordFoundException, BankAccountOperationException {
          Account withdrawfromaccount = accountRepository.findByAccountNumber(accountNumber);
         if ( withdrawfromaccount ==null) 
                throw new NoRecordFoundException("Could Not Find Account With AccountNumber: "+accountNumber,"Account Number Not Found");
         
         if ( amount.compareTo(BigDecimal.ZERO) <= 0) 
                throw new BankAccountOperationException("Invalid Withdrawal  Amount","Invalid Withdrawal  Amount");
           
         if ( withdrawfromaccount .getAccountType().compareTo(AccountType.SAVINGS) == 0) {
               System.out.println("Withdraw from Savings");
               
             //check minimum balance
              BigDecimal newCurrentBalance= withdrawfromaccount.getCurrentBalance().subtract(amount);
               if ( newCurrentBalance.compareTo(AccountConstants.SAVINGS_ACCOUNT_MINIMUM_BALANCE) < 0) 
                     throw new BankAccountOperationException("InSuffient Funds To Withdraw","InSuffient Funds To Withdraw");
               
                 System.out.println("New balance :"+newCurrentBalance);
                 withdrawfromaccount.setCurrentBalance(newCurrentBalance);
                 accountRepository.saveAndFlush(  withdrawfromaccount);
                 Transaction transcation =new Transaction();
                 transcation.setAccount(withdrawfromaccount);
                 transcation.setTransactionamount(amount);
                 transcation.setDescription(OperationType.WITHDRAW.toString());
                 transcation.setTranscationtype(TransactionType.DEBIT.toString());
                 transcation.setNewaccountbalance(newCurrentBalance);
                 transcation.setTransactiondate(LocalDateTime.now());
               return    transactionRepository.saveAndFlush(transcation);
               //  result= "Successful Withdraw Amount "+ amount+" "+ "From Account Number" +accountNumber+" "+" Reference :" +createdtransaction.getTransactionId()+" "+"Balance :"+bal;
         }else{
                System.out.println("Withdraw from Current Account");
                BigDecimal maxmumallowedtowithdraw= withdrawfromaccount.getCurrentBalance().add(AccountConstants.CURRENT_ACCOUNT_OVERDRAFT_LIMIT);
                BigDecimal newCurrentBalance= withdrawfromaccount.getCurrentBalance().subtract(amount);
                System.out.println("New balance C :"+newCurrentBalance+" "+maxmumallowedtowithdraw+ " "+amount);
                if ( amount.compareTo(maxmumallowedtowithdraw) > 0) 
                     throw new BankAccountOperationException("Withdrawing Amount Exceeds Maximum Authorized","InSuffient Funds To Withdraw");
                  System.out.println("New balance C2 :"+newCurrentBalance);
                  withdrawfromaccount.setCurrentBalance(newCurrentBalance);
                  accountRepository.saveAndFlush(  withdrawfromaccount);
                  Transaction transcation =new Transaction();
                  transcation.setAccount(withdrawfromaccount);
                  
                  transcation.setTransactionamount(amount);
                  transcation.setDescription(OperationType.WITHDRAW.toString());
                  transcation.setTranscationtype(TransactionType.DEBIT.toString());
                  transcation.setTransactiondate(LocalDateTime.now());
                  transcation.setNewaccountbalance(newCurrentBalance);
                  return        transactionRepository.saveAndFlush(transcation);
               //  result= "Successful Withdraw Amount "+ amount+" "+ "From Account Number" +accountNumber+" "+" Reference :" +createdtransaction.getTransactionId()+" "+"Balance :"+bal;
          }
        // Transaction
    }

    @Override
    public Transaction transfer(String accountNumberFrom, String accountNumberTo, BigDecimal amount) throws NoRecordFoundException, BankAccountOperationException {
         Account accountFrom = accountRepository.findByAccountNumber(accountNumberFrom);
          Account accountTO = accountRepository.findByAccountNumber(accountNumberTo);
         if ( accountFrom ==null) 
                throw new NoRecordFoundException("Could Not Find Account To Transfer Funds From  With AccountNumber: "+accountNumberFrom,"Account Number Not Found");
        
         if ( accountTO ==null) 
                throw new NoRecordFoundException("Could Not Find Account To Transfer Funds To  With AccountNumber: "+accountNumberFrom,"Account Number Not Found");
         if ( amount.compareTo(BigDecimal.ZERO) <= 0) 
                throw new BankAccountOperationException("Invalid Transfer  Amount","Invalid Transfer  Amount");
           
         if (accountFrom .getAccountType().compareTo(AccountType.SAVINGS) == 0) {
               System.out.println("Transfer from Savings");
               BigDecimal newCurrentBalanceFrom= accountFrom.getCurrentBalance().subtract(amount);
               if ( newCurrentBalanceFrom.compareTo(AccountConstants.SAVINGS_ACCOUNT_MINIMUM_BALANCE) < 0) 
                     throw new BankAccountOperationException("InSuffient Funds To Transfer","InSuffient Funds ");
                 System.out.println("New balance :"+newCurrentBalanceFrom);
                 accountFrom.setCurrentBalance(newCurrentBalanceFrom);
                 accountRepository.saveAndFlush(accountFrom);
                 Transaction transcationfrom =new Transaction();
                 transcationfrom.setAccount( accountFrom);
                 transcationfrom.setDescription(OperationType.TRANSFER.toString());
                 transcationfrom.setTranscationtype(TransactionType.DEBIT.toString());
                 transcationfrom.setNewaccountbalance(newCurrentBalanceFrom);
                 transcationfrom.setTransactiondate(LocalDateTime.now());
                 transcationfrom.setTransactionamount(amount);
                 Transaction savetransactionfrom=       transactionRepository.saveAndFlush(transcationfrom);
                 
                 BigDecimal newcurrentBalanceTo= accountTO.getCurrentBalance().add(amount);
                 accountTO.setCurrentBalance(newcurrentBalanceTo);
                 accountRepository.saveAndFlush( accountTO);
                 
                 Transaction transcationTo =new Transaction();
                 transcationTo.setAccount(  accountTO);
                 transcationTo.setDescription(OperationType.TRANSFER.toString());
                 transcationTo.setTranscationtype(TransactionType.CREDIT.toString());
                 transcationTo.setNewaccountbalance(newcurrentBalanceTo);
                 transcationTo.setTransactiondate(LocalDateTime.now());
                 transcationTo.setTransactionamount(amount);
                 transactionRepository.saveAndFlush(transcationTo);
                
                 return  savetransactionfrom;      
                             
           
                // result= "Successful From Transfer Amount "+ amount+" "+ "From Account Number" +savetransactionTo.getAccount().getAccountNumber()
                      //   +" "+" Reference :" +savetransactionTo.getTransactionId()+" TO "+savetransactionTo.getAccount().getAccountNumber();
         }else{
                System.out.println("Transfer from Current Account");
                BigDecimal maxmumallowedtowithdraw= accountFrom.getCurrentBalance().add(AccountConstants.CURRENT_ACCOUNT_OVERDRAFT_LIMIT);
                BigDecimal newCurrentBalance= accountFrom.getCurrentBalance().subtract(amount);
                System.out.println("New balance C :"+newCurrentBalance+" "+maxmumallowedtowithdraw+ " "+amount);
                if ( amount.compareTo(maxmumallowedtowithdraw) > 0) 
                     throw new BankAccountOperationException("Transfer Amount Exceeds Maximum Authorized");
                  System.out.println("New balance C2 :"+newCurrentBalance);
                  accountFrom.setCurrentBalance(newCurrentBalance);
                  accountRepository.saveAndFlush( accountTO);
                  Transaction transcationfrom =new Transaction();
                  transcationfrom.setAccount(accountFrom);
                   transcationfrom.setTransactionamount(amount);
                  transcationfrom.setDescription(OperationType.TRANSFER.toString());
                  transcationfrom.setTranscationtype(TransactionType.DEBIT.toString());
                  transcationfrom.setTransactiondate(LocalDateTime.now());
                  transcationfrom.setNewaccountbalance(newCurrentBalance);
                  Transaction createdtransaction=       transactionRepository.saveAndFlush(transcationfrom);
                  BigDecimal newcurrentBalanceTo= accountTO.getCurrentBalance().add(amount);
                  accountTO.setCurrentBalance(newcurrentBalanceTo);
                  accountRepository.saveAndFlush( accountTO);
                 
                 Transaction transcationTo =new Transaction();
                 transcationTo.setAccount(  accountTO);
                 transcationTo.setDescription(OperationType.TRANSFER.toString());
                 transcationTo.setTranscationtype(TransactionType.CREDIT.toString());
                 transcationTo.setNewaccountbalance(newcurrentBalanceTo);
                 transcationTo.setTransactionamount(amount);
                 transcationTo.setTransactiondate(LocalDateTime.now());
                 transcationTo.setTransactionamount(amount);
                  transactionRepository.saveAndFlush(transcationTo);
               return   createdtransaction;
                             
                   
              //   result= "Successful Withdraw Amount "+ amount+" "+ "From Account Number" +createdtransaction.getAccount().getAccountNumber()+" "+" Reference :" +createdtransaction.getTransactionId();
          }
        
    }

    @Override
    public List<Transaction> getAllTransaction() {
      List<Transaction> listallTranscation=transactionRepository.findAll(Sort.by(Sort.Direction.ASC, "transactiondate"));
              
        return listallTranscation;
    }

    @Override
    public Transaction getTransactionsByTransactionId(long transactionid) throws NoRecordFoundException {
        
         return  transactionRepository.findById(transactionid)
             .orElseThrow(() -> new NoRecordFoundException("Transaction was not found for ID: " + transactionid,"Transaction Not Found"));
         
    }

   
    
    
    @Override
    public List<Transaction> getAllTransactionByDateRange(LocalDate startdate, LocalDate enddate) {
        LocalDate newenddate= enddate .plusDays(1);
        List<Transaction> listTranscation=transactionRepository.findAllByTransactiondateBetween(startdate, newenddate);
        return listTranscation;
    }

    @Override
    public List<Transaction> getTransactionByAcountNumber(String accountNumber) throws NoRecordFoundException {
       Account account = accountRepository.findByAccountNumber(accountNumber);
        
        
         if ( account ==null) 
                throw new NoRecordFoundException("Account Number Not Found for AccountNumber: "+accountNumber,"Account Number Not Found");
         
            List<Transaction> listTranscation=transactionRepository.findByAccountNumber(accountNumber);
        return listTranscation;
    }

    @Override
    public List<Transaction> getTransactionByAcountNumberByDate(String accountNumber, LocalDate startdate, LocalDate enddate) throws NoRecordFoundException {
         LocalDate newenddate= enddate .plusDays(1);
            Account account = accountRepository.findByAccountNumber(accountNumber);
        
         if ( account ==null) 
                throw new NoRecordFoundException("Account Number Not Found for AccountNumber: "+accountNumber,"Account Not Found");
        
        
        List<Transaction> listTranscation=transactionRepository.findAllByAccountNumberByTransactiondateBetween(accountNumber, startdate, newenddate);
        return listTranscation;
    }
    
}
