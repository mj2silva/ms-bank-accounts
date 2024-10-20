package com.ms.accounts.mapper;

import com.ms.accounts.dto.AccountDto;
import com.ms.accounts.entity.Account;

public class AccountMapper {
    public static AccountDto toDto(Account account) {
        AccountDto accountDto = new AccountDto();
        accountDto.setAccountNumber(account.getAccountNumber());
        accountDto.setAccountType(account.getType());
        accountDto.setBranchAddress(account.getBranchAddress());

        return accountDto;
    }

    public static Account toEntity(AccountDto accountDto) {
        Account account = new Account();
        account.setAccountNumber(accountDto.getAccountNumber());
        account.setType(accountDto.getAccountType());
        account.setBranchAddress(accountDto.getBranchAddress());

        return account;
    }
}
