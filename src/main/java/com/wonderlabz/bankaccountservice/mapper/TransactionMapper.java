/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderlabz.bankaccountservice.mapper;

import com.wonderlabz.bankaccountservice.domain.Account;
import com.wonderlabz.bankaccountservice.domain.Transaction;
import com.wonderlabz.bankaccountservice.dto.DepositWithdrawMsgDto;
import com.wonderlabz.bankaccountservice.dto.TransactionDto;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


/**
 *
 * @author tmashakada email:tmashakada10@gmail.com
 */
@Mapper
public interface TransactionMapper {
    TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);
    @Mapping(source = "transaction.transactionamount", target = "amount")
    @Mapping(source = "transaction.newaccountbalance", target = "balance")
    @Mapping(source = "account.accountNumber", target = "accountNumber")
        
    TransactionDto toTransactionDto(Transaction transaction,Account account);
    
    
   //@Mapping(source = "transaction.transactionId", target = "transactionnumber")
   //@Mapping(source = "transaction.newaccountbalance", target = "availablebalance") 
   // DepositWithdrawMsgDto toDepositWithdrawMsgDto(Transaction transaction);
    
    
            
    @Mapping(source = "transactionamount", target = "amount")
    @Mapping(source = "transaction.newaccountbalance", target = "balance")
    List<TransactionDto> toTransactionDtolist(List<Transaction> listtransaction);

    default TransactionDto toTransactionDtolist(Transaction transaction) {
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setAccountNumber(transaction.getAccount().getAccountNumber());
        transactionDto.setAccountName(transaction.getAccount().getCustomer().getFirstname()+"  "+transaction.getAccount().getCustomer().getSurname());
        transactionDto.setAmount(transaction.getTransactionamount());
        transactionDto.setBalance(transaction.getNewaccountbalance());
        transactionDto.setDescription(transaction.getDescription());
        transactionDto.setTransactionId(transaction.getTransactionId());
        transactionDto.setTransactiondate(transaction.getTransactiondate());
        transactionDto.setTranscationtype(transaction.getTranscationtype());
        return transactionDto;
    }
    
    
    default DepositWithdrawMsgDto toDepositWithdrawMsgDto(Transaction transaction) {
        DepositWithdrawMsgDto depositWithdrawMsgDto = new DepositWithdrawMsgDto();
        depositWithdrawMsgDto.setAccountnumber(transaction.getAccount().getAccountNumber());
        depositWithdrawMsgDto.setAvailablebalance(transaction.getNewaccountbalance());
        depositWithdrawMsgDto.setMessage("Successful Deposited R "+transaction.getTransactionamount());
        depositWithdrawMsgDto.setTransactiondate(transaction.getTransactiondate());
        depositWithdrawMsgDto.setTransactionnumber(transaction.getTransactionId());
   
        return depositWithdrawMsgDto;
    
}
     default DepositWithdrawMsgDto toDepositWithdrawMsgWDto(Transaction transaction) {
        DepositWithdrawMsgDto depositWithdrawMsgDto = new DepositWithdrawMsgDto();
        depositWithdrawMsgDto.setAccountnumber(transaction.getAccount().getAccountNumber());
        depositWithdrawMsgDto.setAvailablebalance(transaction.getNewaccountbalance());
        depositWithdrawMsgDto.setMessage("Successful Withdraw R "+transaction.getTransactionamount());
        depositWithdrawMsgDto.setTransactiondate(transaction.getTransactiondate());
        depositWithdrawMsgDto.setTransactionnumber(transaction.getTransactionId());
   
        return depositWithdrawMsgDto;
    
}
}
