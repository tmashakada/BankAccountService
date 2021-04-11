/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderlabz.bankaccountservice.service;

import com.wonderlabz.bankaccountservice.domain.Customer;
import com.wonderlabz.bankaccountservice.exception.EntityAlreadyExistsException;
import com.wonderlabz.bankaccountservice.exception.NoRecordFoundException;
import com.wonderlabz.bankaccountservice.repository.CustomerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tmashakada email:tmashakada10@gmail.com
 */
@Service
public class CustomerServiceImpl  implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;
    /**
     * 
     * @param customer
     * @return
     * @throws EntityAlreadyExistsException 
     */
    @Override
    public Customer createCustomer(Customer customer) throws EntityAlreadyExistsException {
       Customer cust=customerRepository.findByNationalId(customer.getNationalid());
       if(cust!=null)
          throw new EntityAlreadyExistsException("Customer Already Exists With National ID: " + customer.getNationalid(),"Customer Already Exists");
         
       return  customerRepository.saveAndFlush(customer);
      
    }
   /**
    * 
    * @param customerid
    * @return
    * @throws NoRecordFoundException 
    */
    @Override
    public Customer getById(Long customerid) throws NoRecordFoundException {
        return  customerRepository.findById(customerid)
             .orElseThrow(() -> new NoRecordFoundException("Customer was not found for ID: " + customerid,"Customer Not Found"));
    }
    /**
     * 
     * @return 
     */
    @Override
    public List<Customer> getAllCustomers() {
        return  customerRepository.findAll();
    }
    
}
