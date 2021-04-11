/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderlabz.bankaccountservice.service;

import com.wonderlabz.bankaccountservice.domain.Customer;
import com.wonderlabz.bankaccountservice.exception.NoRecordFoundException;
import com.wonderlabz.bankaccountservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author tmashakada email:tmashakada10@gmail.com
 */
public class CustomerServiceImpl  implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public Customer createCustomer(Customer customer) {
        
        return null;
      
    }

    @Override
    public Customer getById(Long customerid) throws NoRecordFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
