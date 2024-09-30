package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Account;
import com.repository.AccountRepository;

@Service
public class AccountService {
	
	@Autowired
	AccountRepository accountRepository;
	
	public String createAccount(Account account) {
		
		Optional<Account> result =  accountRepository.findById(account.getAccno());
		if(result.isPresent()) {
			return "Account number must be unqiue";
		} else if(account.getAmount() < 1000) {
			return "Amount must be greater than 1000";
		} else {
			accountRepository.save(account);
			return "Account created";
		}
		
	}
	
	public String depositAmount(Account acc) {
		Optional<Account> result =  accountRepository.findById(acc.getAccno());
		if(acc.getAmount() > 50000) {
			return "Please provide PAN Number";
		}
		if(result.isPresent()) {
			Account account = result.get();
			account.setAmount(acc.getAmount()+account.getAmount());
			accountRepository.saveAndFlush(account);
			return "Amount deposited successfully";
		}else {
			return "Record not present";
		}
	}
	
	public String withdrawAmount(Account acc) {
		Optional<Account> result =  accountRepository.findById(acc.getAccno());
		if(result.isPresent()) {
			Account account = result.get();
			if (account.getAmount() - acc.getAmount() < 1000) {
				return "Account Balance low";
			} else {
				account.setAmount(account.getAmount()-acc.getAmount());
				accountRepository.saveAndFlush(account);
				return "Amount Withdrawn successfully";
			}
		}else {
			return "Record not present";
		}
	}
	
	public Account checkbalance(Account acc) {
		Optional<Account> result =  accountRepository.findById(acc.getAccno());
		if(result.isPresent()) {
			Account account = result.get();
			return account;
		}else {
			return null;
		}
	}
	
	public String findAccount(int accno) {
		Optional<Account> result =  accountRepository.findById(accno);
		if(result.isPresent()) {
			Account acc = result.get();
			return acc.toString();
		}else {
			return "Record not present";
		}
	}
	
	public Account findAccountByAccNo(int accno) {
		Optional<Account> result =  accountRepository.findById(accno);
		if(result.isPresent()) {
			Account acc = result.get();
			return acc;
		}else {
			return null;
		}
	}

}
