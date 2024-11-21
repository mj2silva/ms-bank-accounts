package com.ms.accounts.service.client;

import com.ms.accounts.dto.client.LoanDto;
import com.ms.restUtilities.dto.ResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "loans", path = "/api/v1")
 public interface LoansFeignClient {

    @PostMapping("/customers/{customerId}]/loans")
    ResponseEntity<ResponseDto> createLoan(@PathVariable long customerId, @RequestBody LoanDto loanDto);

    @GetMapping("/loans/{loanId}")
    ResponseEntity<LoanDto> getLoan(@PathVariable Long loanId);

    @GetMapping("/loans/loan-number/{loanNumber}")
    ResponseEntity<LoanDto> getLoan(@PathVariable String loanNumber);

    @GetMapping("/customers/{customerId}/loans")
    ResponseEntity<List<LoanDto>> getCustomerLoans(@PathVariable Long customerId);

    @PutMapping("/loans/{loanId}")
    ResponseEntity<ResponseDto> updateLoan(@PathVariable Long loanId, @RequestBody LoanDto loanDto);

    @PostMapping("/loans/payments")
    ResponseEntity<ResponseDto> makeLoanPayment(@RequestBody LoanDto loanDto);

    @DeleteMapping("/loans/{loanId}")
    ResponseEntity<Void> deleteLoan(@PathVariable String loanId);
}
