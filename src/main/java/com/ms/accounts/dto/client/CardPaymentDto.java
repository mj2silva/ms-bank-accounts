package com.ms.accounts.dto.client;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CardPaymentDto {
    private Long customerId;
    private String cardNumber;
    private BigDecimal paidAmount;
}
