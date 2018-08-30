package com.qa.project.service;

import java.util.List;
import java.util.Optional;

import com.qa.project.entities.domain.Account;

public interface AccountService {

	List<Account> getAllAccounts();
	
	Optional<Account> getAccountById(Long id);
	
	String addAccount(Account account);
	
	String deleteAccount(Long id);

	String updateAccount(Long id, Account account);
}
