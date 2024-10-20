package com.ms.accounts.service.impl;

import com.ms.accounts.dto.CustomerDto;
import com.ms.accounts.repository.AccountRepository;
import com.ms.accounts.repository.CustomerRepository;
import com.ms.accounts.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;

    @Override
    public void createAccount(CustomerDto customerDto) {

    }
}
