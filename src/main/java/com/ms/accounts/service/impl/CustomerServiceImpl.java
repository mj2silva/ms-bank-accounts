package com.ms.accounts.service.impl;

import com.ms.accounts.dto.CustomerDetailsDto;
import com.ms.accounts.entity.Customer;
import com.ms.accounts.mapper.AccountMapper;
import com.ms.accounts.mapper.CustomerMapper;
import com.ms.accounts.repository.AccountRepository;
import com.ms.accounts.repository.CustomerRepository;
import com.ms.accounts.service.CustomerService;
import com.ms.accounts.service.client.CardsFeignClient;
import com.ms.accounts.service.client.LoansFeignClient;
import com.ms.restUtilities.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;
    private final CardsFeignClient cardsFeignClient;
    private final LoansFeignClient loansFeignClient;

    @Override
    public CustomerDetailsDto getCustomerDetails(Long customerId) {
        var customer = customerRepository
                .findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "customerId", customerId.toString()));
        return getCustomerDetails(customer);
    }

    @Override
    public CustomerDetailsDto getCustomerDetails(String mobileNumber) {
        var customer = customerRepository
                .findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber));
        return getCustomerDetails(customer);
    }

    private CustomerDetailsDto getCustomerDetails(Customer customer) {
        var customerId = customer.getId();
        var account = accountRepository.findByCustomerId(customerId).orElse(null);

        var customerDetailsDto = CustomerMapper.toCustomerDetailsDto(customer);
        customerDetailsDto.setAccount(AccountMapper.toDto(account));

        var cardsResponse = cardsFeignClient.getCustomerCards(customerId);
        var loansResponse = loansFeignClient.getCustomerLoans(customerId);

        if (cardsResponse != null) {
            var cards = cardsResponse.getStatusCode() == HttpStatus.OK ? cardsResponse.getBody() : null;
            customerDetailsDto.setCards(cards);
        }

        if (loansResponse != null) {
            var loans = loansResponse.getStatusCode() == HttpStatus.OK ? loansResponse.getBody() : null;
            customerDetailsDto.setLoans(loans);
        }

        return customerDetailsDto;
    }
}
