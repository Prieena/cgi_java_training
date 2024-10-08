package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bean.User;
import com.service.LoginService;

@Controller
public class MyController {
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	User user;

	@RequestMapping(value = "login",method = RequestMethod.GET)
	public ModelAndView login() {
		System.out.println("I Came Here in login method");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login.jsp");
		return mav;
	}
	
	@RequestMapping(value = "signup")
	public ModelAndView signUp() {
		System.out.println("I Came Here in signup method");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("signup.jsp");
		return mav;
	}
	
	@RequestMapping(value = "loginuser",method = RequestMethod.POST)  // di for request object 
	public ModelAndView loginUser(HttpServletRequest req) {
		String emailid = req.getParameter("emailid");
		String password = req.getParameter("password");
		String typeOfUser = req.getParameter("typeofuser");
		user.setEmailId(emailid);
		user.setPassword(password);
		user.setTypeOfUser(typeOfUser);
		ModelAndView mav = new ModelAndView();
		if(loginService.loginUser(user) == 1 && typeOfUser.equals("user")) {
			mav.setViewName("userlogin.jsp");
		}else if(loginService.loginUser(user) == 1 && typeOfUser.equals("admin")) {
			mav.setViewName("adminlogin.jsp");
		}else {
			mav.setViewName("userloginfail.jsp");
		}
		return mav;
	}
	
	@RequestMapping(value = "signupuser",method = RequestMethod.POST)  // di for request object 
	public ModelAndView signUpUser(HttpServletRequest req) {
		String emailid = req.getParameter("emailid");
		String password = req.getParameter("password");
		String typeOfUser = req.getParameter("typeofuser");
		user.setEmailId(emailid);
		user.setPassword(password);
		user.setTypeOfUser(typeOfUser);
		System.out.println(emailid);
		System.out.println(password);
		System.out.println(typeOfUser);
		ModelAndView mav = new ModelAndView();
		if(loginService.addUser(user) == 1) {
			mav.setViewName("usersignup.jsp");
		}else {
			mav.setViewName("usersignupfail.jsp");
		}
		return mav;
	}
	
}
