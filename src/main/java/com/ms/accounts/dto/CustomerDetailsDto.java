package com.ms.accounts.dto;

import com.ms.accounts.dto.client.CardDto;
import com.ms.accounts.dto.client.LoanDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CustomerDetailsDto extends CustomerDto {
    private List<CardDto> cards;
    private List<LoanDto> loans;
}
