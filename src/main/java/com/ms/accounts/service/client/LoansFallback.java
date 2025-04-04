package com.ms.accounts.service.client;

import com.ms.accounts.dto.client.LoanDto;
import com.ms.restUtilities.dto.ResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LoansFallback implements LoansFeignClient {

    @Override
    public ResponseEntity<LoanDto> getLoan(Long loanId) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseDto> createLoan(long customerId, LoanDto loanDto) {
        return null;
    }

    @Override
    public ResponseEntity<LoanDto> getLoan(String loanNumber) {
        return null;
    }

    @Override
    public ResponseEntity<List<LoanDto>> getCustomerLoans(Long customerId) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseDto> updateLoan(Long loanId, LoanDto loanDto) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseDto> makeLoanPayment(LoanDto loanDto) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteLoan(String loanId) {
        return null;
    }
}
