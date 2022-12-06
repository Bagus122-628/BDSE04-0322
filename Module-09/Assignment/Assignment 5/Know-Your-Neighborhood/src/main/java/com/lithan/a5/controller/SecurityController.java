package com.lithan.a5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.lithan.a5.entity.Users;

@Controller
public class SecurityController {

  @GetMapping("/login")
  public String loginPage(Model model) {
    Users user = new Users();

    model.addAttribute("user", user);

    return "login";
  }
}