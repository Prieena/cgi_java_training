package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.Account;
import com.service.AccountService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AccountController {

	@Autowired
	AccountService accountService;
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String openIndexPage() {   // DI
		return "index";
	}
	@RequestMapping(value = "createaccpage")
	public String createAccountPage(Model model,Account account) {   // DI
		model.addAttribute("acc", account);
		return "createaccpage";
	}

	@RequestMapping(value = "/createacc",method = RequestMethod.POST)
	public String createAccount(Model model,Account account,HttpServletRequest req) {   // DI
		String result = "";
		result = accountService.createAccount(account);
		model.addAttribute("msg", result);
		account.setAccno(0);
		account.setName("");
		account.setAmount(0.0f);
		model.addAttribute("acc", account);
		return "createaccpage";
	}
	
	@RequestMapping(value = "/depositpage")
	public String depositPage(Model model,Account account,HttpServletRequest req) {   // DI
		model.addAttribute("acc", account);
		model.addAttribute("headingvalue", "Deposit Amount Page");
		model.addAttribute("buttonvalue", "Deposit Amount");
		return "depositpage";
	}
	
	@RequestMapping(value = "/updateamount",method = RequestMethod.POST)
	public String deposit(Model model,Account account,HttpServletRequest req) {   // DI
		String result = "";
		String buttonValue = req.getParameter("submitButton");
		if (buttonValue.equals("Deposit Amount")) {
			result = accountService.depositAmount(account);
			model.addAttribute("buttonvalue", "Deposit Amount");
		} else {
			result = accountService.withdrawAmount(account);
			model.addAttribute("buttonvalue", "Withdraw Amount");
		}
		model.addAttribute("msg", result);
		account.setAccno(0);
		account.setName("");
		account.setAmount(0.0f);
		model.addAttribute("acc", account);
		return "depositpage";
	}
	
	@RequestMapping(value = "/withdrawpage")
	public String withdrawPage(Model model,Account account,HttpServletRequest req) {   // DI
		model.addAttribute("acc", account);
		model.addAttribute("headingvalue", "Withdraw Amount Page");
		model.addAttribute("buttonvalue", "Withdraw Amount");
		return "depositpage";
	}
	
	@RequestMapping(value = "/checkbalancepage")
	public String checkBalancepage(Model model,Account account) {   // DI
		model.addAttribute("acc", account);
		return "checkbalance";
	}
	
	@RequestMapping(value = "/checkbalance")
	public String checkBalance(Model model,Account account) {   // DI
		String result = "";
		Account account1 = accountService.checkbalance(account);
		if (account1 == null) {
			result = "Account not present";
		} else {
			result = "Account Balance is "+account1.getAmount();
		}
		model.addAttribute("msg", result);
		model.addAttribute("acc", account);
		return "checkbalance";
	}
	
}
