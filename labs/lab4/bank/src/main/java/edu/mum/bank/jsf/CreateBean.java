package edu.mum.bank.jsf;

import edu.mum.bank.domain.Account;
import edu.mum.bank.service.AccountService;
import edu.mum.bank.service.IAccountService;

import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import java.util.Collection;
import java.util.Map;

@ManagedBean( eager = true)
@ViewScoped
public class CreateBean {

    @ManagedProperty(value = "#{accountService}")
    private AccountService accountService;
    public void setAccountService(AccountService accountService) {
        accountService = accountService;
    }

    @ManagedProperty(value = "#{account}")
    private Account account;

    @ManagedProperty(value = "#{list}")
    private Collection<Account> list;

    public String createAccount() {

        Account newAccount = accountService.createAccount(
                account.getAccountNumber(),
                account.getCustomer().getName());

        if (newAccount != null)
            return "success";
        else
            return "fail";
    }


    public String showDetails() {
        return "details";
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Collection<Account> getList() {
        return accountService.getAllAccounts();
    }

    public void setList(Collection<Account> list) {
        this.list = list;
    }
}
