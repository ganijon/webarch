package edu.mum.bank.domain;

import javax.validation.constraints.*;
import java.util.Date;

public class AccountEntry {

	@Past(message = "Transaction date must be in the past")
	private Date date;

	private double amount;

	@Size(max = 100, message = "Description length must be less than 100")
	private String description;
	private String fromAccountNumber;
	private String fromPersonName;

	public AccountEntry() {
	}

	public AccountEntry(@NotNull Date date,
						@Min(0) double amount,
						@NotNull String description,
						@NotNull String fromAccountNumber,
						@NotNull String fromPersonName) {
		super();
		this.date = date;
		this.amount = amount;
		this.description = description;
		this.fromAccountNumber = fromAccountNumber;
		this.fromPersonName = fromPersonName;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFromAccountNumber() {
		return fromAccountNumber;
	}

	public void setFromAccountNumber(String fromAccountNumber) {
		this.fromAccountNumber = fromAccountNumber;
	}

	public String getFromPersonName() {
		return fromPersonName;
	}

	public void setFromPersonName(String fromPersonName) {
		this.fromPersonName = fromPersonName;
	}

}
