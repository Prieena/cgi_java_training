package com.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.User;
import com.dao.LoginDao;

@Service								// Service layer annotation 
public class LoginService {
	//private ProductDao pd = new ProductDao();
	
	@Autowired
	LoginDao loginDao;
	
	public int addUser(User user) {
		List<User> listOfUsers = loginDao.retrieveAllUsers();
		// boolean existingUser = listOfUsers.stream().anyMatch(userCheck -> userCheck.getEmailId().equals(user.getEmailId()) && userCheck.getPassword().equals(user.getPassword()) && userCheck.getTypeOfUser().equals(user.getTypeOfUser()));
		boolean existingUser = false;
		for (User userCheck: listOfUsers) {
			if (userCheck.getEmailId().equals(user.getEmailId()) && userCheck.getPassword().equals(user.getPassword()) && userCheck.getTypeOfUser().equals(user.getTypeOfUser())) {
				existingUser = true;
				System.out.println("Found user!");
				break;
			}
		}
		if(!user.getEmailId().contains("@")) {
			return 0;
		} else if (existingUser) {
			return 0;
		}else if(loginDao.addUser(user)>0) {
			return 1;
		}else {
			return 0;
		}
	}
	
	public int loginUser(User user) {
		List<User> listOfUsers = loginDao.retrieveAllUsers();
		if(listOfUsers == null) {
			return 0;
		}

		// boolean existingUser = listOfUsers.stream().anyMatch(userCheck -> userCheck.getEmailId().equals(user.getEmailId()) && userCheck.getPassword().equals(user.getPassword()) && userCheck.getTypeOfUser().equals(user.getTypeOfUser()));
		boolean existingUser = false;
		System.out.println("In login Service");
		for (User userCheck: listOfUsers) {
			if (userCheck.getEmailId().equals(user.getEmailId()) && userCheck.getPassword().equals(user.getPassword()) && userCheck.getTypeOfUser().equals(user.getTypeOfUser())) {
				existingUser = true;
				System.out.println("Found user!");
				break;
			}
		}

		if (existingUser == true) {
			return 1;
		} else return 0;
	}
	
	
}