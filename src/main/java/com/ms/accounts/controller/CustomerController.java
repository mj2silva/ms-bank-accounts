package com.ms.accounts.controller;

import com.ms.accounts.dto.CustomerDetailsDto;
import com.ms.accounts.service.CustomerService;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<CustomerDetailsDto> getCustomerDetails(@PathVariable @Positive(message = "Invalid customer id") String customerId) {
        var longCustomerId = Long.parseLong(customerId);
        return ResponseEntity.ok(customerService.getCustomerDetails(longCustomerId));
    }

    @GetMapping("/customer/mobile-number/{mobileNumber}")
    public ResponseEntity<CustomerDetailsDto> getCustomerDetailsByUsername(
            @Pattern(regexp = "^$|[0-9]{10}", message = "Mobile number must be 10 digits")
            @PathVariable
            String mobileNumber
    ) {
        return ResponseEntity.ok(customerService.getCustomerDetails(mobileNumber));
    }
}
