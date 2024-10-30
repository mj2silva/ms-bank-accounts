package com.ms.accounts.service.impl;

import com.ms.accounts.dto.CustomerDto;
import com.ms.accounts.exception.CustomerAlreadyExistsException;
import com.ms.restUtilities.exception.ResourceNotFoundException;
import com.ms.accounts.mapper.AccountMapper;
import com.ms.accounts.mapper.CustomerMapper;
import com.ms.accounts.repository.AccountRepository;
import com.ms.accounts.repository.CustomerRepository;
import com.ms.accounts.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;

    @Override
    public void createAccount(CustomerDto customerDto) {
        var userExists = customerRepository.existsByMobileNumber(customerDto.getMobileNumber());
        if (userExists) throw new CustomerAlreadyExistsException("Customer with given mobile number already exists");

        var customer = CustomerMapper.toCustomer(customerDto);
        var savedCustomer = customerRepository.save(customer);

        if (customerDto.getAccount() == null) return;

        var customerAccount = AccountMapper.toEntity(customerDto.getAccount());
        customerAccount.setCustomerId(savedCustomer.getId());

        accountRepository.save(customerAccount);
    }

    @Override
    public CustomerDto getCustomer(Long customerId) {
        var customer = customerRepository
                .findById(customerId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Customer", "id", customerId.toString())
                );

        var account = accountRepository
                .findByCustomerId(customer.getId())
                .orElseThrow(
                        () -> new ResourceNotFoundException("Account", "customer id", customer.getId().toString())
                );

        var customerDto = CustomerMapper.toCustomerDto(customer);
        customerDto.setAccount(AccountMapper.toDto(account));

        return customerDto;
    }


    @Override
    public CustomerDto getCustomer(String phoneNumber) {
        var customer = customerRepository
                .findByMobileNumber(phoneNumber)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Customer", "mobile number", phoneNumber)
                );

        var account = accountRepository
                .findByCustomerId(customer.getId())
                .orElseThrow(
                        () -> new ResourceNotFoundException("Account", "customer id", customer.getId().toString())
                );

        var customerDto = CustomerMapper.toCustomerDto(customer);
        customerDto.setAccount(AccountMapper.toDto(account));

        return customerDto;
    }

    @Override
    @Transactional
    public boolean updateCustomer(Long customerId, CustomerDto customerDto) {

        var existingCustomer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "id", customerId.toString()));

        existingCustomer.setName(customerDto.getName());
        existingCustomer.setEmail(customerDto.getEmail());
        existingCustomer.setMobileNumber(customerDto.getMobileNumber());

        customerRepository.save(existingCustomer);

        if (customerDto.getAccount() != null) {
            var account = accountRepository.findByCustomerId(customerId)
                    .orElseThrow(() -> new ResourceNotFoundException("Account", "customer id", customerId.toString()));

            account.setType(customerDto.getAccount().getAccountType());
            account.setBranchAddress(customerDto.getAccount().getBranchAddress());

            accountRepository.save(account);
        }

        return true;
    }

    @Override
    public void deleteCustomer(String phoneNumber) {
        var customer = customerRepository
                .findByMobileNumber(phoneNumber)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Customer", "mobile number", phoneNumber)
                );

        var account = accountRepository
                .findByCustomerId(customer.getId())
                .orElseThrow(
                        () -> new ResourceNotFoundException("Account", "customer id", customer.getId().toString())
                );

        accountRepository.delete(account);
        customerRepository.delete(customer);
    }
}
