package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public String openLoginPage() {
		System.out.println("Login page open");
		return "login";
	}
	
	@RequestMapping(value = "/signin",method = RequestMethod.POST)
	public String checkUserDetails(HttpServletRequest req) {   // DI for request object. 
		String emailid = req.getParameter("emailid");
		String password = req.getParameter("password");
		if(emailid.equals("akash@gmail.com") && password.equals("123")) {
			return "success";
		}else {
			return "failure";
		}
	}
}