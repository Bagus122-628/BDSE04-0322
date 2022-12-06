package com.lithan.a5.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lithan.a5.entity.Store;
import com.lithan.a5.exception.StoreNotFoundException;
import com.lithan.a5.service.StoreService;

@Controller
public class StoreController {

	private static final Logger LOGGER = LoggerFactory.getLogger(StoreController.class);

	@Autowired
	StoreService storeService;

	@GetMapping("/")
	public ModelAndView home() {
		LOGGER.info("Inside home of StoreController");

		ModelAndView mv = new ModelAndView("store");

		List<Store> stores = storeService.listStore();

		mv.addObject("stores", stores);

		return mv;
	}

	@GetMapping("/stores")
	public ModelAndView searchStore(@RequestParam("name") String keyword) throws StoreNotFoundException {
		LOGGER.info("Inside searchStore of StoreController");

		ModelAndView mv = new ModelAndView();

		List<Store> stores = storeService.search(keyword);

		if (stores.isEmpty()) {
			throw new StoreNotFoundException("Store not found");
		}

		mv.addObject("stores", stores);
		mv.setViewName("search");
		return mv;
	}

	// Add Store
	@GetMapping("/addStore")
	public String addStore(Model model) {
		Store store = new Store();

		model.addAttribute("store", store);

		return "add-store";
	}

	@PostMapping("/addStore/save")
	public String saveAddStore(@ModelAttribute("store") Store store) {

		storeService.addStore(store);

		return "redirect:/";
	}

	// Edit Store
	@GetMapping("/editStore")
	public String editStore(@RequestParam("id") int id, Model model) {

		Store store = storeService.findById(id);

		model.addAttribute("store", store);

		return "edit-store";
	}

	@PostMapping("/editStore/save")
	public String saveEditStore(@ModelAttribute("store") Store store) {

		storeService.editStore(store);

		return "redirect:/";
	}

	// Delete Store
	@GetMapping("/deleteStore")
	public String saveEditStore(@RequestParam("id") int id) {

		storeService.deleteStore(id);

		return "redirect:/";
	}

}
