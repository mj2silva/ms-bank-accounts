package com.ms.accounts.constants;

public class AccountConstants {
    private AccountConstants() {
        // Private constructor in order to avoid object initialization
    }

    public static final String CUSTOMER_PATH = "/customer";
    public static final String ACCOUNT_PATH = CUSTOMER_PATH + "/account";
    public static final String ACCOUNT_CREATED_MSG = "Account was successfully created!";
}
