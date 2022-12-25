package xyz.cars.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xyz.cars.restapi.entity.UserAccount;
import xyz.cars.restapi.exception.ResourceNotFoundException;
import xyz.cars.restapi.models.UserDto;
import xyz.cars.restapi.repository.UserAccountRepository;
import xyz.cars.restapi.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

  @Autowired
  private UserService userService;

  @Autowired
  private UserAccountRepository userRepo;

  @GetMapping("/")
  public List<UserAccount> listUser() throws Exception {
    List<UserAccount> listUser = userService.listUser();
    return listUser;
  }

  @GetMapping("/{idUser}")
  public UserAccount getUser(@PathVariable("idUser") int idUser) throws Exception {
    UserAccount user = userService.getUserById(idUser);

    if (user == null) {
      throw new ResourceNotFoundException("User", "id", idUser);
    }
    return user;
  }

  @GetMapping("/me")
  public UserDto getLoginUser(Authentication authentication) {
    UserAccount user = userRepo.findByEmail(authentication.getName()).get();

    if (user == null) {
      throw new ResourceNotFoundException("User", "Email", authentication.getName());
    }
    return new UserDto(user.getIdUser(), user.getName(), user.getEmail());
  }
}
