/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderlabz.bankaccountservice.repository;

import com.wonderlabz.bankaccountservice.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author tmashakada email:tmashakada10@gmail.com
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByNationalId(String nationalId);
}
