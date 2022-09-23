package com.abcjob.register;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.abcjob.login.LoginService;
import com.abcjob.login.LoginUser;
import com.abcjob.mailsender.EmailSenderService;

@Controller
public class RegisterController {
	
	@Autowired
	RegisterService registerService;
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	EmailSenderService senderService;
	
	@RequestMapping("/register")
	public ModelAndView registerPage(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		
		if(loginService.getCurrentUser(session) != null) {
			mv.setViewName("redirect:/");
			return mv;
		} else {
			RegisterUser user = new RegisterUser();
			RegisterProfile profile = new RegisterProfile();
			RegisterJob job = new RegisterJob();
			user.setProfile(profile);
			user.getProfile().setJob(job);
			mv.addObject("register", user);
		}
		
		List<RegisterJob> listJob = registerService.listJob();
		mv.addObject("listJob", listJob);
		mv.setViewName("register");
		
		return mv;
	}
	
	@RequestMapping(value = "/saveRegister", method = RequestMethod.POST)
	public String saveRegister(@ModelAttribute("register") RegisterUser user, Model model) {
		LoginUser logUser = loginService.loadUserByEmail(user.getEmail());
		
		if(logUser != null) {
			if(user.getEmail().equals(logUser.getEmail())) {
				model.addAttribute("message", "This email address is already registered");
				model.addAttribute("error", "border: 1px solid #b02a37;");
				return "register";
			}
		}
		
		registerService.saveRegister(user);
		
		senderService.sendEmail(user.getEmail(), 
				"Account Activation", 
				"localhost:8080/abcjob/register-confirmation?id=" 
				+ loginService.loadUserByEmail(user.getEmail()).getId_user()
				);
		
		String email = user.getEmail();
		model.addAttribute("email", email);
		return "thank-you";
	}
	
	@RequestMapping(value = "/register-confirmation", method = RequestMethod.GET)
	public String registerConfirmation(@RequestParam("id") int id) {
		RegisterUser user = registerService.findUser(id);
		user.setEnabled(true);
		registerService.userActivation(user);
		
		return "register-confirmation";
	}

}
