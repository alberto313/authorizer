/**
 * 
 */
package com.exercise.service;

import static com.exercise.util.Constants.CACHE_ACCOUNT_KEY;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.exercise.model.Account;
import com.exercise.model.AccountAccount;
import com.exercise.model.AccountResponse;
import com.exercise.model.Transaction;
import com.exercise.repository.IBankRepository;

/**
 * @author Alberto
 *
 */
@Service
public class BankService implements IBankService {
	
	@Autowired
	private IBankRepository bankRepository;
	
	@Autowired
	private ICacheService cache;

	@Override
	public AccountResponse createAccount(Account body) {
		
		if (cache.checkIfExists(CACHE_ACCOUNT_KEY)) {
			//TODO throw an exception
		}
		
		AccountAccount accountDetail = bankRepository.createAccount(body.getAccount().getAvailableLimit(), body.getAccount().isActiveCard());
		
		cache.store(CACHE_ACCOUNT_KEY, accountDetail);
		
		AccountResponse res = new AccountResponse();
		res.setAccount(accountDetail);
		
		return res;
	}

	@Override
	public AccountResponse performTransaction(Transaction body) {
		
		AccountAccount cachedAccount = cache.get(CACHE_ACCOUNT_KEY, AccountAccount.class).orElseThrow(() -> new Exception(""));
		
		
		return null;
	}

}
