package com.samuel.junit.tests.factory;

import com.samuel.junit.entities.Account;

public class AccountFactory {

    public static Account createEmptyAccount() {
        return new Account(1L, 0.0);
    }

    public static Account createAccount(double initialValue) {
        return new Account(1L, initialValue);
    }
}
