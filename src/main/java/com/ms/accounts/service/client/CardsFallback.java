package com.ms.accounts.service.client;

import com.ms.accounts.dto.client.CardDto;
import com.ms.accounts.dto.client.CardExpenseDto;
import com.ms.accounts.dto.client.CardPaymentDto;
import com.ms.restUtilities.dto.ResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CardsFallback implements CardsFeignClient {
    @Override
    public ResponseEntity<ResponseDto> createCard(Long customerId, CardDto cardDto) {
        return null;
    }

    @Override
    public ResponseEntity<CardDto> getCard(Long cardId) {
        return null;
    }

    @Override
    public ResponseEntity<CardDto> getCard(String cardNumber) {
        return null;
    }

    @Override
    public ResponseEntity<List<CardDto>> getCustomerCards(Long customerId) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseDto> updateCard(Long cardId, CardDto cardDto) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseDto> makeCardPayment(CardPaymentDto cardPaymentDto) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseDto> makeCardExpense(CardExpenseDto cardExpenseDto) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteCard(String cardId) {
        return null;
    }
}
