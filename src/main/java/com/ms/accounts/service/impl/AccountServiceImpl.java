package com.ms.accounts.service.impl;

import com.ms.accounts.dto.CustomerDto;
import com.ms.accounts.entity.Account;
import com.ms.accounts.mapper.CustomerMapper;
import com.ms.accounts.repository.AccountRepository;
import com.ms.accounts.repository.CustomerRepository;
import com.ms.accounts.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;

    @Override
    public void createAccount(CustomerDto customerDto) {
        var customer = CustomerMapper.toCustomer(customerDto);
        var savedCustomer = customerRepository.save(customer);

        var customerAccount = new Account();
        customerAccount.setCustomerId(savedCustomer.getId());
        customerAccount.setType("SAVINGS");
        customerAccount.setBranchAddress("Av. Javier Prado Este 25455");

        accountRepository.save(customerAccount);
    }
}
