package com.abcjob.search;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SearchController {
	
	@Autowired
	SearchService searchService;
	
	@RequestMapping("/search-user")
	public ModelAndView searchUser() {
		ModelAndView mv = new ModelAndView();
		SearchForm form = new SearchForm();
		
		mv.setViewName("search-user");
		mv.addObject("searchUser", form);
		return mv;
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(@ModelAttribute("searchUser") SearchForm searchForm, Model model) {
		SearchForm form = new SearchForm();
		String keyword = searchForm.getKeyword();
		List<SearchProfile> result = searchService.search(keyword);
		
		model.addAttribute("keyword", keyword);
		model.addAttribute("result", result);
		model.addAttribute("searchUser", form);
		return "search-user";
	}
	
	@RequestMapping(value = "/view-profile", method = RequestMethod.GET)
	public ModelAndView viewProfile(@RequestParam("id") int id) {
		SearchProfile profile = searchService.loadUserById(id);
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("view-profile");
		mv.addObject("view", profile);
		return mv;
	}
}
