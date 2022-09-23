package com.abcjob.forgot_password;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ForgotPasswordController {
	
	@Autowired
	ForgotPasswordService forgotPasswordService;
	
	@RequestMapping("/forgot-password")
	public ModelAndView forgotPassword() {
		ModelAndView mv = new ModelAndView();
		
		ForgotPasswordUser user = new ForgotPasswordUser();
		
		mv.setViewName("forgot-password");
		mv.addObject("fpUser", user);
		return mv;
	}
	
	@RequestMapping("/forgot-password-confirmation")
	public String forgotPasswordConfirmation(@ModelAttribute("fpUser") ForgotPasswordUser user, Model model) {
		
		ForgotPasswordUser fpUser = forgotPasswordService.findUser(user.getEmail());
		
		if(fpUser == null) {
			model.addAttribute("message", "Invalid account");
			model.addAttribute("error", "border: 1px solid #b02a37;");
			return "forgot-password";
		} else {
			forgotPasswordService.forgotPassword(fpUser);
		}
		
		return "forgot-password-confirmation";
	}
}
