/**
 * 
 */
package com.exercise.service;

import java.util.ArrayList;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.AgendaFilter;
import org.kie.api.runtime.rule.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.exercise.model.AccountAccount;

/**
 * @author Z749313
 *
 */
@Component
public class BusinessRulerService {

	@Autowired
	private KieContainer kieContainer;
	
	public ArrayList<String> createNewAccountRules(AccountAccount account, ArrayList<String> violations) {
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.setGlobal("violations", violations);
		kieSession.insert(account);
		kieSession.fireAllRules(new AgendaFilter() {
			
			@Override
			public boolean accept(Match match) {
				return "Account must initialized".equals(match.getRule().getName());
			}
		});
		kieSession.dispose();
		return violations;
	}
	
	public ArrayList<String> accountNotInitializedRule(AccountAccount account, ArrayList<String> violations) {
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.setGlobal("violations", violations);
		kieSession.insert(account);
		kieSession.fireAllRules(new AgendaFilter() {
			
			@Override
			public boolean accept(Match match) {
				return "Account not initialized to transaction".equals(match.getRule().getName());
			}
		});
		kieSession.dispose();
		return violations;
	}
}
