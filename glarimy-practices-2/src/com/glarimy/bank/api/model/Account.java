package com.glarimy.bank.api.model;

import java.util.ArrayList;
import java.util.Collection;

public class Account {
	CustomerDetail customerDetail;
	Collection<Transaction> transactions = new ArrayList<>();
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
