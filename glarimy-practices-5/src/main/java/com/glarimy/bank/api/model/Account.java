package com.glarimy.bank.api.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Account {
	@OneToOne(cascade = CascadeType.ALL)
	CustomerDetail customerDetail;
	@OneToMany(cascade = CascadeType.ALL)
	Collection<Transaction> transactions = new ArrayList<>();
	@Id
	@GeneratedValue
	int accountNumber;
	double balance;

	public CustomerDetail getCustomerDetail() {
		return customerDetail;
	}

	public void setCustomerDetail(CustomerDetail customerDetail) {
		this.customerDetail = customerDetail;
	}

	public Collection<Transaction> getTransactions() {
		return transactions;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
}
