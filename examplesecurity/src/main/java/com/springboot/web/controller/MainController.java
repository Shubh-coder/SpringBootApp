package com.springboot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	  
	@RequestMapping("/")
	public String home()
	{
		System.out.println("this is home page");
		return "home";
	}
	// showing content of JSP page Response on webserver using Viewpage(src->main->home.jsp page) 
	@RequestMapping("/contact")
	public String contact() {
		System.out.println("this is contact page");
		return "contact";
	}

	
	//  responce of current method for that we use @responseBody Annotations.
	@RequestMapping("/test")
	@ResponseBody
	public String test()
	{
		int a=10,b=20;
		return "sum of a & b: "+a+b;
	}
	
}
