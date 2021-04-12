/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderlabz.bankaccountservice.service;

import com.wonderlabz.bankaccountservice.domain.Customer;
import com.wonderlabz.bankaccountservice.exception.CustomerException;
import com.wonderlabz.bankaccountservice.exception.EntityAlreadyExistsException;
import com.wonderlabz.bankaccountservice.exception.NoRecordFoundException;
import java.util.List;

/**
 *
 * @author tmashakada email:tmashakada10@gmail.com
 */
public interface CustomerService {
    public Customer createCustomer(Customer customer)throws EntityAlreadyExistsException,CustomerException;
    public Customer getById(Long customerid)throws NoRecordFoundException;
    public List<Customer> getAllCustomers();
}
