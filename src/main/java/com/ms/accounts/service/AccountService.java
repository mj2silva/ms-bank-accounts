package com.ms.accounts.service;

import com.ms.accounts.dto.CustomerDto;
import jakarta.validation.Valid;

public interface AccountService {

    /**
     * Creates a customer account.
     *
     * @param customerDto A CustomerDto object containing new user account information.
     */
    void createAccount(CustomerDto customerDto);

    /**
     * Fetches customer details by customer ID.
     *
     * @param customerId The ID of the customer.
     * @return A CustomerDto object containing customer details.
     */
    CustomerDto getCustomer(Long customerId);

    /**
     * Fetches customer details by phone number.
     *
     * @param phoneNumber The phone number of the customer.
     * @return A CustomerDto object containing customer details.
     */
    CustomerDto getCustomer(String phoneNumber);

    /**
     * Updates existing customer details.
     *
     * @param customerDto An object containing the updated user account information.
     * @return A boolean indicating whether the update was successful.
     */
    boolean updateCustomer(Long customerId, @Valid CustomerDto customerDto);

    /**
     * Deletes the customer account by phone number.
     *
     * @param phoneNumber The phone number of the customer.
     */
    void deleteCustomer(String phoneNumber);
}
