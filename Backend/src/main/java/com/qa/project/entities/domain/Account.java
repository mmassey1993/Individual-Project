package com.qa.project.entities.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name="Account")
public class Account {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String forename;
	private String surname;
	@Size(min=6, max=6)
	private String accountNumber;
	
	
	public Account() {
		
	}
	
	
	public Account (String forename, String surname, String accountnumber) {
		this.forename = forename;
		this.surname = surname;
		this.accountNumber = accountnumber;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getForename() {
		return forename;
	}
	public void setForename(String forename) {
		this.forename = forename;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountnumber) {
		this.accountNumber = accountnumber;
	}
	
}
