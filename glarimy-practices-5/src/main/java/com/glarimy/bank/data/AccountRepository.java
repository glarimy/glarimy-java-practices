package com.glarimy.bank.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.glarimy.bank.api.model.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Integer> {
}
