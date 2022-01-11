package com.threem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController 
{
	
	@RequestMapping("/")
	public String home(Model model)
	{
		model.addAttribute("title","home-smart");
		return "home";
	}
	
	@RequestMapping("/register")
	public String register(Model model)
	{
		//model.addAttribute("title","home-smart");
		return "register";
	}
	
	@RequestMapping("/signin")
	public String signIn(Model model)
	{
		//model.addAttribute("title","home-smart");
		return "signin";
	}
//	
//	@RequestMapping("/user")
//	public String user(Model model)
//	{
//		//model.addAttribute("title","home-smart");
//		return "user";
//	}

}
