package com.glarimy.bank.service;

import java.util.Collection;

import com.glarimy.bank.api.Bank;
import com.glarimy.bank.api.TransactionType;
import com.glarimy.bank.api.exceptions.AccountNotFoundException;
import com.glarimy.bank.api.exceptions.BankException;
import com.glarimy.bank.api.exceptions.InsufficientBalanceException;
import com.glarimy.bank.api.exceptions.InvalidRequestException;
import com.glarimy.bank.api.model.Account;
import com.glarimy.bank.api.model.CustomerDetail;
import com.glarimy.bank.api.model.Transaction;
import com.glarimy.bank.api.model.TransactionRequest;
import com.glarimy.bank.data.AccountRepository;
import com.glarimy.bank.data.RepositoryException;

public class SimpleBank implements Bank {
	private AccountRepository repository;

	public AccountRepository getRepository() {
		return repository;
	}

	public void setRepository(AccountRepository repository) {
		this.repository = repository;
	}

	@Override
	public int openAccountFor(CustomerDetail customerDetail) throws InvalidRequestException, BankException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double transact(TransactionRequest request)
			throws InvalidRequestException, InsufficientBalanceException, AccountNotFoundException, BankException {
		if (request == null)
			throw new InvalidRequestException();
		if (request.getAmount() < 500)
			throw new InvalidRequestException();
		try {
			Account account = repository.read(request.getAccountNumber());
			if (request.getType() == TransactionType.DEBIT) {
				if (account.getBalance() < request.getAmount())
					throw new InsufficientBalanceException();
				account.setBalance(account.getBalance() - request.getAmount());
			} else {
				account.setBalance(account.getBalance() + request.getAmount());
			}
			repository.update(account);
			return account.getBalance();
		} catch (RepositoryException ex) {
			throw new AccountNotFoundException();
		}
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
