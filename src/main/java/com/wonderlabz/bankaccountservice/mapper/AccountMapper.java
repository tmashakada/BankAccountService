/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderlabz.bankaccountservice.mapper;

import com.wonderlabz.bankaccountservice.domain.Account;
import com.wonderlabz.bankaccountservice.domain.Transaction;
import com.wonderlabz.bankaccountservice.dto.AccountCreationDto;
import com.wonderlabz.bankaccountservice.dto.AccountDto;
import java.time.LocalDateTime;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author tmashakada email:tmashakada10@gmail.com
 */
@Mapper
public interface AccountMapper {
       AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

      Account toAccount(AccountCreationDto accountCreationDto);
      
  //    AccountDto toAccountDto(Account account);
       
      default AccountDto toAccountDto(Account account) {
          AccountDto accountDto=new AccountDto();
          accountDto.setAccountName(account.getCustomer().getFirstname()+" "+account.getCustomer().getSurname());
          accountDto.setAccountNumber(account.getAccountNumber());
          accountDto.setAccountType(account.getAccountType().toString());
          accountDto.setCurrentBalance(account.getCurrentBalance());
          accountDto.setMessage("New "+ accountDto.getAccountType()+ " Account Created");
          accountDto.setTimestamp(account.getCreatedate());
           return accountDto;
          
      }
      
     
      
}
