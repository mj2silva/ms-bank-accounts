package com.ms.accounts.dto.client;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CardDto {
    private Long id;
    private String cardNumber;
    private Long customerId;
    private String type;
    private BigDecimal totalLimit;
    private BigDecimal amountUsed;
    private BigDecimal availableAmount;
}
