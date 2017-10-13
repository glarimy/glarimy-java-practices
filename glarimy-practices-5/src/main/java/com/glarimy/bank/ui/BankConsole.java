package com.glarimy.bank.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.glarimy.bank.api.Bank;
import com.glarimy.bank.api.TransactionType;
import com.glarimy.bank.api.model.CustomerDetail;
import com.glarimy.bank.api.model.TransactionRequest;

public class BankConsole {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("bank.xml");
		Bank bank = context.getBean(Bank.class);
		CustomerDetail customer = new CustomerDetail();
		customer.setName("Krishna");
		customer.setAdharNumber("123456789876543");
		int no = bank.openAccountFor(customer);
		TransactionRequest request = new TransactionRequest();
		request.setAccountNumber(no);
		request.setAmount(750);
		request.setType(TransactionType.CREDIT);
		double balance = bank.transact(request);
		System.out.println("Balance of transaction: " + balance);
	}
}
