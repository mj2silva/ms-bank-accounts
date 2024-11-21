package com.ms.accounts.dto.client;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class LoanDto {
    private Long loanId;
    private String loanNumber;
    private Long customerId;
    private String type;
    private BigDecimal totalLoan;
    private BigDecimal amountPaid;
    private BigDecimal outstandingAmount;
}
