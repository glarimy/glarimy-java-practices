package com.glarimy.bank.service;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.BeforeClass;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import com.glarimy.bank.api.TransactionType;
import com.glarimy.bank.api.exceptions.AccountNotFoundException;
import com.glarimy.bank.api.exceptions.InsufficientBalanceException;
import com.glarimy.bank.api.exceptions.InvalidRequestException;
import com.glarimy.bank.api.model.Account;
import com.glarimy.bank.api.model.TransactionRequest;
import com.glarimy.bank.data.AccountRepository;

@RunWith(Theories.class)
public class SimpleBankTransactionTest {
	private static SimpleBank bank;

	public static class ExceptionTestData {
		int accountNumber;
		TransactionType type;
		double amount;
		@SuppressWarnings("rawtypes")
		Class exception;

		@SuppressWarnings("rawtypes")
		public ExceptionTestData(int accountNumber, TransactionType type, double amount, Class exception) {
			super();
			this.accountNumber = accountNumber;
			this.type = type;
			this.amount = amount;
		}
	}

	@BeforeClass
	public static void setup() {
		bank = new SimpleBank();

		AccountRepository repo = mock(AccountRepository.class);
		Account account = new Account();
		account.setAccountNumber(1);
		when(repo.read(1)).thenReturn(account);
		when(repo.read(-1)).thenThrow(new AccountNotFoundException());
		bank.setRepository(repo);
	}

	public static class ValidTestData {
		int accountNumber;
		TransactionType type;
		double amount;
		double balance;

		public ValidTestData(int accountNumber, TransactionType type, double amount, double balance) {
			super();
			this.accountNumber = accountNumber;
			this.type = type;
			this.amount = amount;
			this.balance = balance;
		}
	}

	@DataPoints
	public static ExceptionTestData[] exceptionData = {
			new ExceptionTestData(1, TransactionType.DEBIT, 0, InvalidRequestException.class),
			new ExceptionTestData(1, TransactionType.DEBIT, 100, InvalidRequestException.class),
			new ExceptionTestData(1, TransactionType.DEBIT, -500, InvalidRequestException.class),
			new ExceptionTestData(-1, TransactionType.DEBIT, 500, AccountNotFoundException.class) };

	@DataPoints
	public static ValidTestData[] validData = { new ValidTestData(1, TransactionType.CREDIT, 600, 600) };

	@Theory
	public void testInvalidTransactions(ExceptionTestData data) {
		TransactionRequest request = new TransactionRequest();
		request.setAccountNumber(data.accountNumber);
		request.setType(data.type);
		request.setAmount(data.amount);
		try {
			bank.transact(request);
			fail("Must throw exception");
		} catch (RuntimeException isbe) {
			if (isbe.getClass() != data.exception) {
				fail("Wrong Exception");
			}
		}
	}

	@Theory
	public void testValidTransactions(ValidTestData data) {
		TransactionRequest request = new TransactionRequest();
		request.setAccountNumber(data.accountNumber);
		request.setType(data.type);
		request.setAmount(data.amount);
		try {
			double balance = bank.transact(request);
			assertTrue(balance == data.balance);
		} catch (RuntimeException isbe) {
			fail("Wrong Exception");
		}
	}

}
