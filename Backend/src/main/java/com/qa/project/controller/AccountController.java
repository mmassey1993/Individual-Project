package com.qa.project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.qa.project.entities.domain.Account;
import com.qa.project.service.AccountService;


@RestController
@RequestMapping("/accounts")
public class AccountController {
	
	
	private final AccountService accountService;
	
	@Autowired
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	@GetMapping("/getAll")
	@ResponseBody
	public List<Account> getAllAccounts(){
		return accountService.getAllAccounts();
	}
	
	@GetMapping("/get/{id}")
	@ResponseBody
	public Optional<Account> getAccountById(@PathVariable Long id) {
		return accountService.getAccountById(id);
	}
	
	@PostMapping("/add")
	public String addAccount(@RequestBody Account account) {
		return accountService.addAccount(account);		
	}
	
	@PutMapping("/update/{id}")
	public String updateAccount(@PathVariable Long id, @RequestBody Account account) {
		return accountService.updateAccount(id, account);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteAccount(@PathVariable Long id) {
		return accountService.deleteAccount(id);
	}

}
