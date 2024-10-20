package com.ms.accounts.controller;

import com.ms.accounts.constants.AccountConstants;
import com.ms.accounts.dto.CustomerDto;
import com.ms.accounts.dto.ResponseDto;
import com.ms.accounts.service.AccountService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class AccountsController {

    private final AccountService accountService;

    @PostMapping(AccountConstants.ACCOUNT_PATH)
    public ResponseEntity<ResponseDto> createAccount(@RequestBody @Valid CustomerDto customerDto) {
        accountService.createAccount(customerDto);
        ResponseDto responseDto = new ResponseDto(200, AccountConstants.ACCOUNT_CREATED_MSG);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(responseDto);
    }
}
