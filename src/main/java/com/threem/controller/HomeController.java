package com.threem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.threem.entities.User;
import com.threem.repo.UserRepository;

@Controller
public class HomeController 
{
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/")
	public String home(Model model)
	{
		model.addAttribute("title","home-smart");
		return "home";
	}
	
	@RequestMapping("/register")
	public String register(Model model)
	{
		model.addAttribute("title","register-smart");
		model.addAttribute("user",new User());
		return "register";
	}
	
	@RequestMapping("/signin")
	public String signIn(Model model)
	{
	   model.addAttribute("title","signin-smart");
	   model.addAttribute("user", new User());
		return "signin";
	}
	
	//handler for registering user
	@RequestMapping(value="/do_register",method=RequestMethod.POST)
	public String registerUser(@ModelAttribute("user") User user,Model model,RedirectAttributes redirAttrs)
	{
		
		User result=this.userRepository.save(user);
		model.addAttribute("user",result);
		System.out.println("Result"+result);
		System.out.println("User"+user);
		
		redirAttrs.addFlashAttribute("success", "Registered successfully.");

		return "redirect:/register/";
		 
	}
	
//	@RequestMapping(value="/do_signin",method=RequestMethod.POST)
//	public String signinUser(@ModelAttribute("user") User user,Model model)
//	{
//		
//		model.addAttribute("user",user);
//		System.out.println("User in signing"+user);
//		
//		return "dashboard";
//		
//		
//	}

}
