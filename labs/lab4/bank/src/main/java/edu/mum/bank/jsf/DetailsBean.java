package edu.mum.bank.jsf;

import edu.mum.bank.domain.Account;
import edu.mum.bank.service.AccountService;
import edu.mum.bank.service.IAccountService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.Map;

@ManagedBean
@ViewScoped
public class DetailsBean {

    private static IAccountService accountService = new AccountService();

    private Account account;


    @PostConstruct
    public void init() {
        Map<String, String> params = FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap();

        long accNo = Long.parseLong(params.get("accountNumber"));

        account = accountService.getAccount(accNo);
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
