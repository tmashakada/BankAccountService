/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderlabz.bankaccountservice.mapper;

import com.wonderlabz.bankaccountservice.domain.Customer;
import com.wonderlabz.bankaccountservice.domain.Transaction;
import com.wonderlabz.bankaccountservice.dto.CustomerDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author tmashakada email:tmashakada10@gmail.com
 */
@Mapper
public interface  CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
    Customer toCustomer(CustomerDto customerDto);

   // CustomerDto toCustomerDto(Customer customer);
    
    default CustomerDto toCustomerDto(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
          customerDto.setCreateddate(customer.getCreatedate());
          customerDto.setFirstname(customer.getFirstname());
          customerDto.setId(customer.getId());
          customerDto.setMessage("Succesful Created New Customer");
          customerDto.setMobilenumber(customer.getMobilenumber());
          customerDto.setNationalid(customer.getNationalid());
          customerDto.setSurname(customer.getSurname());
      
   
        return customerDto;
    }
}
