package edu.mum.bank;

import cs544.exercise5_3.bank.service.AccountService;
import cs544.exercise5_3.bank.service.IAccountService;

/**
 * Singleton
 */
public enum AppServices {
    INSTANCE;

    AppServices() {
        AccountService = new AccountService();
    }

    public IAccountService AccountService;
}
