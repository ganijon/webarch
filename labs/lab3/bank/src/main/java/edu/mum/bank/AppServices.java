package edu.mum.bank;

import cs544.exercise5_3.bank.domain.Account;
import cs544.exercise5_3.bank.service.AccountService;
import cs544.exercise5_3.bank.service.IAccountService;

/**
 * Singleton
 */
public enum AppServices {
    INSTANCE;

    AppServices() {
        AccountService = new AccountService();
        populateTestData();
    }

    private void populateTestData(){
        Account acc1 = AccountService.createAccount(1100L, "Alice Burrows");
        acc1.deposit(100);
        acc1.withdraw(25);

        Account acc2 = AccountService.createAccount(2200L, "Bob Christensen");
        acc2.deposit(500);
        acc2.transferFunds(acc1, 200, "paycheck");

        Account acc3 = AccountService.createAccount(3300L, "Cole Dominique");
        acc3.deposit(300);
        acc3.transferFunds(acc1, 100, "paycheck");
        acc3.deposit(500);

        Account acc4 = AccountService.createAccount(4400L, "Dave Evans");
        acc4.deposit(600);
        acc4.withdraw(50);
        acc4.transferFunds(acc3, 100, "refund");
    }

    public IAccountService AccountService;
}
