package com.glarimy.bank.api.model;

import com.glarimy.bank.api.TransactionType;

public class TransactionRequest {
	int accountNumber;
	double amount;
	TransactionType type;

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public TransactionType getType() {
		return type;
	}

	public void setType(TransactionType type) {
		this.type = type;
	}
}
