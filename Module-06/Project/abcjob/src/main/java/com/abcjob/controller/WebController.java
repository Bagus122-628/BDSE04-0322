package com.abcjob.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.abcjob.login.LoginService;

@Controller
public class WebController {
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("home");
		return mv;
	}
}

//	@RequestMapping("/login")
//	public ModelAndView login() {
//		ModelAndView mv = new ModelAndView("login");
//		return mv;
//	}
	
//	@RequestMapping("/register")
//	public ModelAndView register() {
//		ModelAndView mv = new ModelAndView("register");
//		return mv;
//	}
	
//	@RequestMapping("/thank-you")
//	public ModelAndView thankYou() {
//		ModelAndView mv = new ModelAndView("thank-you");
//		return mv;
//	}
	
//	@RequestMapping("/user-profile")
//	public ModelAndView userProfile() {
//		ModelAndView mv = new ModelAndView("user-profile");
//		return mv;
//	}
	
//	@RequestMapping("/view-profile")
//	public ModelAndView viewProfile() {
//		ModelAndView mv = new ModelAndView("view-profile");
//		return mv;
//	}
	
//	@RequestMapping("/edit-profile")
//	public ModelAndView editProfile() {
//		ModelAndView mv = new ModelAndView("edit-profile");
//		return mv;
//	}
	
//	@RequestMapping("/search-user")
//	public ModelAndView searchUser() {
//		ModelAndView mv = new ModelAndView("search-user");
//		return mv;
//	}
		
//	@RequestMapping("/forgot-password")
//	public ModelAndView forgotPassword() {
//		ModelAndView mv = new ModelAndView("forgot-password");
//		return mv;
//	}
//	
//	@RequestMapping("/forgot-password-confirmation")
//	public ModelAndView forgotPasswordConfirmation() {
//		ModelAndView mv = new ModelAndView("forgot-password-confirmation");
//		return mv;
//	}
	
//	@RequestMapping("/change-password")
//	public ModelAndView changePassword() {
//		ModelAndView mv = new ModelAndView("change-password");
//		return mv;
//	}

