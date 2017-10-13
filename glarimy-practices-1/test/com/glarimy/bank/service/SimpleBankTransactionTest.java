package com.glarimy.bank.service;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.glarimy.bank.api.Bank;
import com.glarimy.bank.api.TransactionType;
import com.glarimy.bank.api.exceptions.BankException;
import com.glarimy.bank.api.exceptions.InvalidRequestException;
import com.glarimy.bank.api.model.TransactionRequest;

public class SimpleBankTransactionTest {
	@Test
	public void testInvalidTransactions() {
		TransactionRequest request = new TransactionRequest();
		request.setAccountNumber(1);
		request.setType(TransactionType.DEBIT);
		request.setAmount(100);
		try {
			Bank bank = new SimpleBank();
			bank.transact(request);
			fail("Must throw exception");
		} catch (InvalidRequestException ire) {

		} catch (BankException be) {
			fail("Wrong Exception");
		}
	}

	@Test
	public void testValidTransactions() {
		TransactionRequest request = new TransactionRequest();
		request.setAccountNumber(1);
		request.setType(TransactionType.CREDIT);
		request.setAmount(600);
		try {
			Bank bank = new SimpleBank();
			double balance = bank.transact(request);
			assertTrue(balance == 600);
		} catch (RuntimeException isbe) {
			fail("Wrong Exception");
		}
	}
}
