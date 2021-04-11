/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderlabz.bankaccountservice.respository;

import com.wonderlabz.bankaccountservice.domain.Account;
import com.wonderlabz.bankaccountservice.domain.AccountType;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author tmashakada email:tmashakada10@gmail.com
 */ 
public interface AccountRespository extends JpaRepository<Account, Long>{
    Account findByAccountNumber(String accountNumber);
    List<Account> findByAccountType(AccountType accounttype);
}
