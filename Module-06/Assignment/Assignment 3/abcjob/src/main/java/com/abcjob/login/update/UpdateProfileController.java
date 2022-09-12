package com.abcjob.login.update;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.abcjob.login.LoginProfile;
import com.abcjob.login.LoginService;

@Controller
public class UpdateProfileController {

	@Autowired
	UpdateProfileService updateService;
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping("/edit-profile")
	public ModelAndView editProfile(HttpSession session) {
		ModelAndView mv = new ModelAndView("edit-profile");
		LoginProfile profile = loginService.getCurrentUser(session);
		mv.addObject("profile", profile);
		return mv;
	}
	
	@RequestMapping(value = "/save-edit", method = RequestMethod.POST)
	public String saveEditProfile(@ModelAttribute("profile") LoginProfile profile,HttpSession session) {
		LoginProfile editedProfile = updateService.saveEdit(profile);

		session.setAttribute("profile", editedProfile);
		return "redirect:/user-profile";
	}
}
