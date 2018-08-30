package com.qa.project.entities.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.project.entities.domain.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long>{

}
