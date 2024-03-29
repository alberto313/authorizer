/**
 * 
 */
package com.exercise.repository;

import org.springframework.stereotype.Service;

import com.exercise.model.AccountAccount;

/**
 * Repository to simulate the persist from database and create a new account
 */
@Service(value="bankRepository")
public class BankRepository implements IBankRepository {

	/**
	 * Create a new account
	 */
	@Override
	public AccountAccount createAccount(int availableLimit, boolean activeCard) {
		return new AccountAccount().activeCard(activeCard).availableLimit(availableLimit);
	}

}
