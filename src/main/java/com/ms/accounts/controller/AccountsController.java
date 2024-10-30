package com.ms.accounts.controller;

import com.ms.accounts.constants.AccountConstants;
import com.ms.accounts.dto.CustomerDto;
import com.ms.restUtilities.dto.ResponseDto;
import com.ms.restUtilities.dto.ValidationGroups;
import com.ms.accounts.service.AccountService;
import jakarta.validation.groups.Default;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@Validated
public class AccountsController {

    private final AccountService accountService;

    @PostMapping(AccountConstants.ACCOUNT_PATH)
    public ResponseEntity<ResponseDto> createAccount(
            @RequestBody @Validated({ValidationGroups.CreationGroup.class, Default.class}) CustomerDto customerDto
    ) {
        accountService.createAccount(customerDto);
        ResponseDto responseDto = new ResponseDto(200, AccountConstants.ACCOUNT_CREATED_MSG);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(responseDto);
    }

    @GetMapping(AccountConstants.CUSTOMER_PATH + "/{customerId}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable Long customerId) {
        var customer = accountService.getCustomer(customerId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(customer);
    }

    @GetMapping(AccountConstants.CUSTOMER_PATH + "/phone-number/{phoneNumber}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable String phoneNumber) {
        var customer = accountService.getCustomer(phoneNumber);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(customer);
    }

    @PutMapping(AccountConstants.CUSTOMER_PATH + "/{customerId}")
    public ResponseEntity<ResponseDto> updateCustomer(
            @PathVariable Long customerId,
            @RequestBody @Validated({ValidationGroups.UpdateGroup.class, Default.class}) CustomerDto customerDto
    ) {
        var updated = accountService.updateCustomer(customerId, customerDto);
        if (updated) return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseDto(HttpStatus.OK.value(), "Account updated")
        );
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping(AccountConstants.CUSTOMER_PATH + "/phone-number/{phoneNumber}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable String phoneNumber) {
        accountService.deleteCustomer(phoneNumber);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
