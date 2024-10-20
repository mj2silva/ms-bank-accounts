package com.ms.accounts.service;

import com.ms.accounts.dto.CustomerDto;

public interface AccountService {
    /**
     * Creates a customer account
     * @param customerDto An object containing new user account information
     */
    void createAccount(CustomerDto customerDto);
}
