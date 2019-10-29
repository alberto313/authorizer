/**
 * 
 */
package com.exercise.service;

import static com.exercise.util.Constants.CACHE_ACCOUNT_KEY;
import static com.exercise.util.Constants.CACHE_TRANSACTIONS_KEY;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
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
import com.exercise.model.TransactionTransaction;
import com.exercise.model.TransactionsRepository;
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
		
		AccountAccount accountDetail = retrieveDataFromCache(CACHE_ACCOUNT_KEY, AccountAccount.class).orElse(null);
		
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
		
		AccountAccount accountDetail = retrieveDataFromCache(CACHE_ACCOUNT_KEY, AccountAccount.class).orElse(null);
		TransactionsRepository transactions = retrieveDataFromCache(CACHE_TRANSACTIONS_KEY, TransactionsRepository.class).orElse(new TransactionsRepository(new ArrayList<TransactionTransaction>()));
		
		List<String> violations = businessRuler.preConditionsTransactionRules(accountDetail, body.getTransaction(), new ArrayList<String>(), transactions);
		
		

		
		if (violations.isEmpty()) {
			transactions.getTransactions().add(body.getTransaction());
			accountDetail.setAvailableLimit(accountDetail.getAvailableLimit() - body.getTransaction().getAmount());
			cacheService.store(CACHE_TRANSACTIONS_KEY, transactions);
			cacheService.store(CACHE_ACCOUNT_KEY, accountDetail);
		}
		
		
		
		
		res.violations(violations).account(accountDetail);
		return res;
	}
	
	private <T> Optional<T> retrieveDataFromCache(String key, Class<T> type) {
		return cacheService.get(key, type);
	}

}
