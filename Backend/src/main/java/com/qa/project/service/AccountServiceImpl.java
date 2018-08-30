package com.qa.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.project.entities.domain.Account;
import com.qa.project.entities.repository.AccountRepo;
import com.qa.projects.constants.Constants;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	AccountRepo repo;

	@Override
	public List<Account> getAllAccounts() {
		
		return repo.findAll();
	}
	
	@Override
	public Optional<Account> getAccountById(Long id) {
		return repo.findById(id);
	}

	@Override
	public String addAccount(Account account) {
		
		repo.save(account);
		return Constants.ACCOUNT_ADDED;
	}

	@Override
	public String deleteAccount(Long id) {
		Optional<Account> accountInDB = repo.findById(id);
		if (accountInDB.isPresent()) {
			repo.deleteById(id);
			return Constants.ACCOUNT_DELETED;
		} else {
			return Constants.ACCOUNT_NOT_FOUND;
		}
	}

	@Override
	public String updateAccount(Long id, Account accToUpdate) {
		Optional<Account> accountInDB = repo.findById(id);
		if (accountInDB.isPresent()) {
			Account account = accountInDB.get();
			account.setForename(accToUpdate.getForename());
			account.setSurname(accToUpdate.getSurname());
			account.setAccountNumber(accToUpdate.getAccountNumber());
			repo.save(account);
			return Constants.ACCOUNT_UPDATED;
		} else {
			return Constants.ACCOUNT_NOT_FOUND;
		}
		 
	}

}
