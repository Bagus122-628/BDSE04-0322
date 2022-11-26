package com.lithan.a3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lithan.a3.entity.Store;
import com.lithan.a3.service.StoreRepository;

@Controller
public class StoreController {

	@Autowired
	StoreRepository storeService;
	
	@GetMapping("/store")
	public ModelAndView viewStore() {
		ModelAndView mv = new ModelAndView("store");
		
		List<Store> stores = storeService.listAll();
		
		mv.addObject("stores", stores);
		
		return mv;
	}

	@GetMapping("/addStore")
	public String addStore(Model model) {
		Store store = new Store();
		
		model.addAttribute("store", store);
		
		return "add-store";
	}
	
	@PostMapping("/saveAddStore")
	public String saveAddStore(@ModelAttribute("store") Store store) {
		
		storeService.save(store);
		
		return "redirect:/store";
	}
}
