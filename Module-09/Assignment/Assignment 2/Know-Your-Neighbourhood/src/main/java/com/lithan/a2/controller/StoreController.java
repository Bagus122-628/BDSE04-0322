package com.lithan.a2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lithan.a2.entity.Store;
import com.lithan.a2.service.StoreService;

@Controller
public class StoreController {
	
	@Autowired
	private StoreService storeService;
	
	@RequestMapping("/")
	public ModelAndView storeHome() {
		ModelAndView mv = new ModelAndView("store");
		Store store = new Store();
		
		mv.addObject("store", store);
		return mv;
	}
	
	@RequestMapping(value = "/stores", method = RequestMethod.POST)
	public String addStore(@ModelAttribute("store") Store store) {
		
		if(store != null) {
			storeService.addStore(store);
		}
		
		return "redirect:/";
	}
}
