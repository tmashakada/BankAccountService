/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderlabz.bankaccountservice.repository;

import com.wonderlabz.bankaccountservice.domain.Transaction;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

/**
 *
 * @author tmashakada email:tmashakada10@gmail.com
 */
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{
    
    @Query(value = "SELECT * FROM transactionhistory WHERE transactiondate >= :startDate AND transactiondate <= :endDate ",
            nativeQuery = true)        
    List<Transaction>  findAllByTransactiondateBetween(@Param("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                                         @Param("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate);
       
                                     
     @Query(value = "SELECT * FROM transactionhistory"
              + "   JOIN account On account.id=transactionhistory.account_id"
              + "   WHERE account.accountnumber=:accountNumber AND transactiondate >= :startDate"
              + " AND transactiondate <= :endDate", nativeQuery = true)          
     List<Transaction>    findAllByAccountNumberByTransactiondateBetween  (@Param("accountNumber")  String accountNumber,
                                                         @Param("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                                         @Param("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate);
       
     @Query(value = "SELECT * FROM transactionhistory"
              + "   JOIN account On account.id=transactionhistory.account_id"
              + "   WHERE account.accountnumber=:accountNumber",
              nativeQuery = true)
     List<Transaction>    findByAccountNumber (@Param("accountNumber")  String accountNumber );
       
}
