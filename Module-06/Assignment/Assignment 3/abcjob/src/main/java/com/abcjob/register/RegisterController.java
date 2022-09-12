package com.abcjob.register;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.abcjob.login.LoginService;

@Controller
public class RegisterController {
	
	@Autowired
	RegisterService registerService;
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping("/register")
	public String registerPage(HttpSession session, Model model) {
		
		if(loginService.getCurrentUser(session) != null) {
			return "redirect:/";
		} else {
			RegisterUser user = new RegisterUser();
			RegisterProfile profile = new RegisterProfile();
			user.setProfile(profile);
			model.addAttribute("register", user);
		}

		return "register";
	}
	
	@RequestMapping(value = "/thank-you", method = RequestMethod.POST)
	public String saveRegister(@ModelAttribute("register") RegisterUser user, Model model, HttpSession session ) {
		registerService.saveRegister(user);
		
		String email = user.getEmail();
		model.addAttribute("email", email);
		
		return "thank-you";
	}
}
