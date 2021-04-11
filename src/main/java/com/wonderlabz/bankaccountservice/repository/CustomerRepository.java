/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderlabz.bankaccountservice.repository;

import com.wonderlabz.bankaccountservice.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author tmashakada email:tmashakada10@gmail.com
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByNationalid(String nationalId);
}
