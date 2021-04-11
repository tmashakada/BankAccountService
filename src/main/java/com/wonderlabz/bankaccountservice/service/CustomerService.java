/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderlabz.bankaccountservice.service;

import com.wonderlabz.bankaccountservice.domain.Customer;
import com.wonderlabz.bankaccountservice.exception.NoRecordFoundException;

/**
 *
 * @author tmashakada email:tmashakada10@gmail.com
 */
public interface CustomerService {
    public Customer createCustomer(Customer customer);
    public Customer getById(Long customerid)throws NoRecordFoundException;
}
