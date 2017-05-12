package edu.mum.bank.domain;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.*;

@ManagedBean
public class Account {

    Collection<AccountEntry> entryList = new ArrayList<AccountEntry>();

    @ManagedProperty(value="#{customer}")
    private Customer customer;

    @Max(1000)
    @Min(100)
    long accountnumber;


    public Account() {}
    public Account (long accountnr){
		this.accountnumber = accountnr;
	}

	public long getAccountNumber() {
		return accountnumber;
	}
	public void setAccountNumber(long accountnumber) {
		this.accountnumber = accountnumber;
	}
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public Collection<AccountEntry> getEntryList() {
        return entryList;
    }

	public double getBalance() {
		double balance=0;
		for (AccountEntry entry : entryList) {
			balance+=entry.getAmount();
		}
		return balance;
	}
	public void deposit(double amount){
		AccountEntry entry = new AccountEntry(new Date(), amount, "deposit", "", "");
		entryList.add(entry);
	}
	public void withdraw(double amount){
		AccountEntry entry = new AccountEntry(new Date(), -amount, "withdraw", "", "");
		entryList.add(entry);
	}
	public void transferFunds(Account toAccount, double amount, String description){
		AccountEntry fromEntry = new AccountEntry(new Date(), -amount, description, ""+toAccount.getAccountNumber(), toAccount.getCustomer().getName());
		AccountEntry toEntry = new AccountEntry(new Date(), amount, description, ""+toAccount.getAccountNumber(), toAccount.getCustomer().getName());
		entryList.add(fromEntry);
		toAccount.addEntry(toEntry);
	}

    private void addEntry(AccountEntry entry){
        entryList.add(entry);
    }


}
