package xyz.cars.restapi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import xyz.cars.restapi.entity.UserAccount;
import xyz.cars.restapi.repository.UserAccountRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

  @Autowired
  private UserAccountRepository userRepo;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    UserAccount user = userRepo.findByUsername(username);

    if (user == null) {
      throw new UsernameNotFoundException("Invalid username or password");
    }

    return new CustomUserDetails(user);
  }
}