package com.glarimy.bank.api;

import java.util.Collection;

import com.glarimy.bank.api.exceptions.AccountNotFoundException;
import com.glarimy.bank.api.exceptions.BankException;
import com.glarimy.bank.api.exceptions.InsufficientBalanceException;
import com.glarimy.bank.api.exceptions.InvalidRequestException;
import com.glarimy.bank.api.model.Account;
import com.glarimy.bank.api.model.CustomerDetail;
import com.glarimy.bank.api.model.Transaction;
import com.glarimy.bank.api.model.TransactionRequest;

/**
 * Bank offers a way for the customers to open accounts, transact on the
 * accounts and get the status of the accounts
 * 
 * @author krishna@glarimy.com
 * @version Draft
 * @since 2017
 */
public interface Bank {
	/**
	 * Opens a new account in the bank
	 * 
	 * @param customerDetail
	 *            details of the customer for whom the account is to be opened
	 *            for
	 * @return number of the newly created account
	 * @throws InvalidRequestException
	 *             if the customer name is empty, if the adhar number is of size
	 *             less than 16 characters and if the adhar number is already
	 *             attached to another account in the bank
	 * @throws BankException
	 *             for internal reasons
	 */
	public int openAccountFor(CustomerDetail customerDetail) throws InvalidRequestException, BankException;

	/**
	 * Updates the account based on the transaction. Types of transactions
	 * include deposit and withdrawl
	 * 
	 * @param request
	 *            transaction request with account number, type of request and
	 *            amount of transaction
	 * @return
	 * @throws InvalidRequestException
	 *             if the amount is less than Rs. 500
	 * @throws InsufficientBalanceException
	 *             if the account balance is less than the amount requested for
	 *             withdral
	 * @throws AccountNotFoundException
	 *             if account is not found with the given number
	 * @throws BankException
	 *             for internal reasons
	 */
	public double transact(TransactionRequest request)
			throws InvalidRequestException, InsufficientBalanceException, AccountNotFoundException, BankException;

	/**
	 * Gets the list of all transactions carried on a specific account
	 * 
	 * @param accountNumber
	 *            account number whose transactions are requested for
	 * @return collection of all the transactions. collection can be empty for
	 *         new accounts
	 * @throws AccountNotFoundException
	 *             if no account is found with the supplied account number
	 * @throws BankException
	 *             for internal reasons
	 */
	public Collection<Transaction> getHistory(int accountNumber) throws AccountNotFoundException, BankException;

	/**
	 * Gets the statement of the account with a specific number
	 * 
	 * @param accountNumber
	 *            account number whose statement is requested for
	 * @return statement of the account
	 * @throws AccountNotFoundException
	 *             if no account is found with the supplied account number
	 * @throws BankException
	 *             for internal reasons
	 */
	public Account getStatement(int accountNumber) throws AccountNotFoundException, BankException;
}
