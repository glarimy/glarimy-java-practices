package com.glarimy.bank.data;

import com.glarimy.bank.api.model.Account;

public interface AccountRepository {
	public Account read(int number) throws RepositoryException;

	public void update(Account account) throws RepositoryException;

	public int create(Account account) throws RepositoryException;
}
