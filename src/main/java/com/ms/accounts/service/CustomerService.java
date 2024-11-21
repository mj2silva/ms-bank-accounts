package com.ms.accounts.service;

import com.ms.accounts.dto.CustomerDetailsDto;

public interface CustomerService {
    CustomerDetailsDto getCustomerDetails(String mobileNumber);
    CustomerDetailsDto getCustomerDetails(Long customerId);
}
