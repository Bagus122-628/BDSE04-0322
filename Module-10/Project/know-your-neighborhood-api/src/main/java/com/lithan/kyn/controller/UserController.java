package com.lithan.kyn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lithan.kyn.entity.UserAccount;
import com.lithan.kyn.exception.ResourceNotFoundException;
import com.lithan.kyn.model.UserDto;
import com.lithan.kyn.repository.UserAccountRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {

  @Autowired
  private UserAccountRepository userRepo;

  @GetMapping("/me")
  public UserDto getLoginUser(Authentication authentication) {
    UserAccount user = userRepo.findByEmail(authentication.getName()).get();

    if (user == null) {
      throw new ResourceNotFoundException("User", "Email", authentication.getName());
    }

    return new UserDto(
        user.getUserId(),
        user.getName(),
        user.getEmail(),
        user.getImageUrl(),
        user.getAddress(),
        user.getPhoneNumber());
  }
}
