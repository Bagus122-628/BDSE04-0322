package xyz.cars.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xyz.cars.restapi.entity.UserAccount;
import xyz.cars.restapi.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("/")
  public List<UserAccount> listUser() throws Exception {
    List<UserAccount> listUser = userService.listUser();
    return listUser;
  }

  @GetMapping("/{idUser}")
  public UserAccount getUser(@PathVariable("idUser") int idUser) throws Exception {
    UserAccount user = userService.getUserById(idUser);
    return user;
  }

  @PostMapping("/register")
  public UserAccount addUser(@RequestBody UserAccount user) throws Exception {
    UserAccount newUser = userService.addUser(user);
    return newUser;
  }
}
