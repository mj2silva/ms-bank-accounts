package com.ms.accounts.service.client;

import com.ms.accounts.dto.client.CardDto;
import com.ms.accounts.dto.client.CardExpenseDto;
import com.ms.accounts.dto.client.CardPaymentDto;
import com.ms.restUtilities.dto.ResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "cards", path = "/api/v1", fallback = CardsFallback.class)
public interface CardsFeignClient {

    @PostMapping("/customers/{customerId}/cards")
    ResponseEntity<ResponseDto> createCard(@PathVariable Long customerId, @RequestBody CardDto cardDto);

    @GetMapping("/cards/{cardId}")
    ResponseEntity<CardDto> getCard(@PathVariable Long cardId);

    @GetMapping("/cards/card-number/{cardNumber}")
    ResponseEntity<CardDto> getCard(@PathVariable String cardNumber);

    @GetMapping("/customers/{customerId}/cards")
    ResponseEntity<List<CardDto>> getCustomerCards(@PathVariable Long customerId);

    @PutMapping("cards/{cardId}")
    ResponseEntity<ResponseDto> updateCard(@PathVariable Long cardId, @RequestBody CardDto cardDto);

    @PostMapping("cards/payments")
    ResponseEntity<ResponseDto> makeCardPayment(@RequestBody CardPaymentDto cardPaymentDto);

    @PostMapping("cards/expenses")
    ResponseEntity<ResponseDto> makeCardExpense(@RequestBody CardExpenseDto cardExpenseDto);

    @DeleteMapping("/cards/{cardId}")
    ResponseEntity<Void> deleteCard(@PathVariable String cardId);
}
