package com.glarimy.bank.service;

import java.util.Collection;

import com.glarimy.bank.api.Bank;
import com.glarimy.bank.api.exceptions.AccountNotFoundException;
import com.glarimy.bank.api.exceptions.BankException;
import com.glarimy.bank.api.exceptions.InsufficientBalanceException;
import com.glarimy.bank.api.exceptions.InvalidRequestException;
import com.glarimy.bank.api.model.Account;
import com.glarimy.bank.api.model.CustomerDetail;
import com.glarimy.bank.api.model.Transaction;
import com.glarimy.bank.api.model.TransactionRequest;

public class SimpleBank implements Bank {
	@Override
	public int openAccountFor(CustomerDetail customerDetail) throws InvalidRequestException, BankException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double transact(TransactionRequest request)
			throws InvalidRequestException, InsufficientBalanceException, AccountNotFoundException, BankException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Collection<Transaction> getHistory(int accountNumber) throws AccountNotFoundException, BankException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account getStatement(int accountNumber) throws AccountNotFoundException, BankException {
		// TODO Auto-generated method stub
		return null;
	}

}
