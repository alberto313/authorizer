/**
 * 
 */
package com.exercise.service;

import static com.exercise.util.Constants.CACHE_ACCOUNT_KEY;

import java.util.ArrayList;
import java.util.Optional;

import org.apache.commons.lang3.ArrayUtils;
import org.kie.api.runtime.KieContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.exception.ServiceException;
import com.exercise.model.Account;
import com.exercise.model.AccountAccount;
import com.exercise.model.AccountResponse;
import com.exercise.model.Transaction;
import com.exercise.repository.IBankRepository;

/**
 * @author Alberto
 *
 */
@Service(value="bankService")
public class BankService implements IBankService {
	
	@Autowired
	private IBankRepository bankRepository;
	
	@Autowired
	private ICacheService cacheService;
	
	@Autowired
	private BusinessRulerService businessRuler;

	@Override
	public AccountResponse createAccount(Account body) {

		AccountResponse res = new AccountResponse();
		
		AccountAccount accountDetail = retrieveAccountFromCache().orElse(null);
		
		ArrayList<String> violations = businessRuler.createNewAccountRules(accountDetail, new ArrayList<String>());
		
		
		if (violations.isEmpty()) {
			accountDetail = bankRepository.createAccount(body.getAccount().getAvailableLimit(), body.getAccount().isActiveCard());
			cacheService.store(CACHE_ACCOUNT_KEY, accountDetail);
		}
		res.violations(violations).setAccount(accountDetail);
		
		return res;
	}

	@Override
	public AccountResponse performTransaction(Transaction body) {
		
		AccountResponse res = new AccountResponse();
		
		AccountAccount accountDetail = retrieveAccountFromCache().orElse(null);
		
		ArrayList<String> violations = businessRuler.accountNotInitializedRule(accountDetail, new ArrayList<String>());
		
		
		
		
		if (violations.isEmpty()) {
			
		}
		
		
		
		
		res.violations(violations).account(accountDetail);
		return res;
	}
	
	private Optional<AccountAccount> retrieveAccountFromCache() {
		return cacheService.get(CACHE_ACCOUNT_KEY, AccountAccount.class);
	}

}
