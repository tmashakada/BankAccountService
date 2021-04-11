/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderlabz.bankaccountservice.mapper;

import com.wonderlabz.bankaccountservice.domain.Customer;
import com.wonderlabz.bankaccountservice.dto.CustomerDto;
import com.wonderlabz.bankaccountservice.dto.CustomerRequestDto;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.Mapping;

/**
 *
 * @author tmashakada email:tmashakada10@gmail.com
 */
@Mapper
public interface  CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
    Customer toCustomer(CustomerRequestDto customerRequestDto);

    CustomerDto toCustomerDto(Customer customer);
   
    List<CustomerDto> toCustomerDtoList(List<Customer> listCustomer);
    
   
}
