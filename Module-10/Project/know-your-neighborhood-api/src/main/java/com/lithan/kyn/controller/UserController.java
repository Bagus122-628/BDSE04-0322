package com.lithan.kyn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lithan.kyn.entity.UserAccount;
import com.lithan.kyn.exception.ResourceNotFoundException;
import com.lithan.kyn.model.UserDto;
import com.lithan.kyn.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("")
  public List<UserDto> listUser() {
    List<UserDto> listUser = userService.listUser();

    return listUser;
  }

  @GetMapping("/me")
  public UserDto getLoginUser(Authentication authentication) {
    UserAccount user = userService.findByEmail(authentication.getName());

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

  @GetMapping("/{userId}")
  public UserDto getUser(@PathVariable("userId") int userId) {
    UserAccount user = userService.getById(userId);

    return new UserDto(
        user.getUserId(),
        user.getName(),
        user.getEmail(),
        user.getImageUrl(),
        user.getAddress(),
        user.getPhoneNumber());
  }

  @PutMapping("/edit")
  public UserDto editProfile(@RequestBody UserDto userDto) {
    UserAccount user = userService.editProfile(userDto);

    return new UserDto(
        user.getUserId(),
        user.getName(),
        user.getEmail(),
        user.getImageUrl(),
        user.getAddress(),
        user.getPhoneNumber());
  }
}
