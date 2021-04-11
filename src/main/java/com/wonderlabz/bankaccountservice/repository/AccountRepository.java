/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderlabz.bankaccountservice.repository;

import com.wonderlabz.bankaccountservice.domain.Account;
import com.wonderlabz.bankaccountservice.domain.AccountType;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author tmashakada email:tmashakada10@gmail.com
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{
    Account findByAccountNumber(String accountNumber);
    List<Account> findByAccountType(AccountType accounttype);
    boolean existsByAccountNumber(String accountNumber);
    Account findByCustomerIdAndAccountType(Long customerid,AccountType accounttype);
    
 //customerid accounttype
}
