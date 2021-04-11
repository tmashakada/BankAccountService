/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderlabz.bankaccountservice.controller;

import com.wonderlabz.bankaccountservice.domain.Customer;
import com.wonderlabz.bankaccountservice.dto.CustomerDto;
import com.wonderlabz.bankaccountservice.dto.CustomerRequestDto;
import com.wonderlabz.bankaccountservice.exception.EntityAlreadyExistsException;
import com.wonderlabz.bankaccountservice.exception.NoRecordFoundException;
import com.wonderlabz.bankaccountservice.mapper.CustomerMapper;
import com.wonderlabz.bankaccountservice.service.CustomerServiceImpl;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author tmashakada email:tmashakada10@gmail.com
 */
@RestController
@RequestMapping("/api")
public class CustomerController {
    @Autowired
    private CustomerServiceImpl customerServiceImpl; 
    /**
     * 
     * @param customerRequestDto
     * @return
     * @throws EntityAlreadyExistsException 
     */
    @PostMapping("/customer")
    public ResponseEntity<CustomerDto> createCustomer(@Valid @RequestBody CustomerRequestDto customerRequestDto) throws EntityAlreadyExistsException {
          Customer customer = customerServiceImpl.createCustomer(CustomerMapper
                 .INSTANCE.toCustomer(customerRequestDto));
         return new ResponseEntity<>(CustomerMapper.INSTANCE.toCustomerDto(customer), HttpStatus.CREATED);
          
      }
    /**
     * 
     * @param customerId
     * @return
     * @throws NoRecordFoundException 
     */
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable Long customerId) throws NoRecordFoundException {
       
         Customer customer = customerServiceImpl.getById(customerId);

        return new ResponseEntity<>(CustomerMapper.INSTANCE.toCustomerDto(customer), HttpStatus.OK);
    }
    /**
     * 
     * @return
     * @throws NoRecordFoundException 
     */
    @GetMapping("/customers")
    public ResponseEntity<List<CustomerDto>>  getAllCustomer() throws NoRecordFoundException {
       
         List<Customer> customerlist = customerServiceImpl.getAllCustomers();

        return new ResponseEntity<>(CustomerMapper.INSTANCE.toCustomerDtoList(customerlist ), HttpStatus.OK);
    }
}
