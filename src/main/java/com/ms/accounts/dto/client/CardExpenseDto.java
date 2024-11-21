package com.ms.accounts.dto.client;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CardExpenseDto {
    private String type;
    private String description;
    private String establishmentId;
    private String cardNumber;
    private BigDecimal amount;
}
