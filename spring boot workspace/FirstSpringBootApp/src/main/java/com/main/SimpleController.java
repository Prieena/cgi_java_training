package com.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SimpleController {

	// http://localhost:8080
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String openPage() {
		System.out.println("I came here to open index.html page");
		return "index";// in templates folder it check index.html page must present
	}
	// http://localhost:8080/about
	@RequestMapping(value = "/about",method = RequestMethod.GET)
	public String aboutUs() {
		System.out.println("I came here to open about.html page");
		return "about";// in templates folder it check index.html page must present
	}
	// http://localhost:8080/contact
	@RequestMapping(value = "/contact",method = RequestMethod.GET)
	public String contactUs() {
		System.out.println("I came here to open contact.html page");
		return "contact";// in templates folder it check index.html page must present
	}
}