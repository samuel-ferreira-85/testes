package com.samuel.junit.tests.entities;

import com.samuel.junit.entities.Account;
import com.samuel.junit.tests.factory.AccountFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AccountTests {

    @Test
    @DisplayName("o depósito deve aumentar o saldo e a taxa de desconto quando o valor for positivo")
    public void depositShouldIncreaseBalanceAndDiscountFeeWhenPositiveAmount() {
        double amount = 200.0;
        double expectedValue = 196.0;
        Account acc = AccountFactory.createEmptyAccount();

        acc.deposit(amount);

        Assertions.assertEquals(expectedValue, acc.getBalance());
    }

    @Test
    @DisplayName("o depósito não deve fazer nada quando o valor for negativo")
    public void depositShouldDoNotNothingWhenNegativeAmount() {
        double expectedValue = 100.0;
        Account acc = AccountFactory.createAccount(expectedValue);
        double amount = -200.0;

        acc.deposit(amount);

        Assertions.assertEquals(expectedValue, acc.getBalance());
    }

    @Test
    @DisplayName("o saque total deveria limpar o saldo e retornar o saldo total")
    public void fullWithdrawShouldClearBalanceAndReturnFullBalance() {
        double expectedValue = 0.0;
        double initialBalance = 800.0;
        Account acc = AccountFactory.createAccount(initialBalance);

        double result = acc.fullWithdraw();

        Assertions.assertTrue(expectedValue == acc.getBalance());

        Assertions.assertTrue(result == initialBalance);
    }

    @Test
    @DisplayName("o saque deveria diminuir o saldo quando o saldo for suficiente")
    public void withdrawShouldDecreaseBalanceWhenSufficientBalance() {
        double initialBalance = 800.0;
        Account acc = AccountFactory.createAccount(initialBalance);

        acc.withdraw(500.0);

        Assertions.assertEquals(300.0, acc.getBalance());
    }

    @Test
    @DisplayName("o saque deveria lançar uma exceção quando o saldo for insuficiente")
    public void withdrawShouldThrowExceptionWhenInsufficientBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Account acc = AccountFactory.createAccount(100.0);
            acc.withdraw(150.0);
        });
    }
}
