package com.ms.accounts.mapper;

import com.ms.accounts.dto.CustomerDetailsDto;
import com.ms.accounts.dto.CustomerDto;
import com.ms.accounts.entity.Customer;

public class CustomerMapper {
    public static CustomerDto toCustomerDto(Customer customer) {
        if (customer == null) return null;

        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setEmail(customer.getEmail());
        customerDto.setName(customer.getName());
        customerDto.setMobileNumber(customer.getMobileNumber());

        return customerDto;
    }

    public static Customer toCustomer(CustomerDto customerDto) {
        if (customerDto == null) return null;

        Customer customer = new Customer();
        customer.setId(customerDto.getId());
        customer.setEmail(customerDto.getEmail());
        customer.setName(customerDto.getName());
        customer.setMobileNumber(customerDto.getMobileNumber());
        return customer;
    }

    public static CustomerDetailsDto toCustomerDetailsDto(Customer customer) {
        if (customer == null) return null;

        CustomerDetailsDto customerDetailsDto = new CustomerDetailsDto();
        customerDetailsDto.setId(customer.getId());
        customerDetailsDto.setEmail(customer.getEmail());
        customerDetailsDto.setName(customer.getName());
        customerDetailsDto.setMobileNumber(customer.getMobileNumber());

        return customerDetailsDto;
    }
}
