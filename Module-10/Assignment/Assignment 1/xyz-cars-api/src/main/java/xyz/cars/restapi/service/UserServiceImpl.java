package xyz.cars.restapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import xyz.cars.restapi.entity.UserAccount;
import xyz.cars.restapi.repository.UserAccountRepository;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserAccountRepository userRepo;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Override
  public UserAccount getUserById(int idUser) {
    UserAccount user = userRepo.findById(idUser).get();
    return user;
  }

  @Override
  public List<UserAccount> listUser() {
    List<UserAccount> listUser = userRepo.findAll();
    return listUser;
  }

  @Override
  public UserAccount addUser(UserAccount user) throws Exception {
    UserAccount newUser = new UserAccount();

    newUser.setUsername(user.getUsername());
    newUser.setPassword(passwordEncoder.encode(user.getPassword()));
    userRepo.save(newUser);

    return newUser;
  }
}
