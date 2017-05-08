package edu.mum.bank.jsf;

import edu.mum.bank.domain.Account;
import edu.mum.bank.service.AccountService;
import edu.mum.bank.service.IAccountService;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.util.Collection;
import java.util.Map;

@ManagedBean(name = "accountController", eager = true)
public class AccountController {

    private static IAccountService accountService = new AccountService();

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

        Map<String, String> params = FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap();

        long accNo = Long.parseLong(params.get("accountNumber"));

        Account account = accountService.getAccount(accNo);
        if (account != null) {
            setAccount(account);
            return "details";
        }
        else
            return "fail";
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
