package com.glarimy.bank.api.exceptions;

public class BankException extends RuntimeException {
	private static final long serialVersionUID = -5056462109580188574L;

	public BankException() {
		super();
	}

	public BankException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public BankException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public BankException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public BankException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
