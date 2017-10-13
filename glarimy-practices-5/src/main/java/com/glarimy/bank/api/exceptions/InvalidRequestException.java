package com.glarimy.bank.api.exceptions;

public class InvalidRequestException extends BankException {

	private static final long serialVersionUID = 6826230672778209095L;

	public InvalidRequestException() {
		// TODO Auto-generated constructor stub
	}

	public InvalidRequestException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public InvalidRequestException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidRequestException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InvalidRequestException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
