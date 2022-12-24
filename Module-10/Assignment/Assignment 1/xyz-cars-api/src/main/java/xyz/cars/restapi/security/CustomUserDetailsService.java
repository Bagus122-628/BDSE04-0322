package xyz.cars.restapi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import xyz.cars.restapi.entity.UserAccount;
import xyz.cars.restapi.exception.ResourceNotFoundException;
import xyz.cars.restapi.repository.UserAccountRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

  @Autowired
  private UserAccountRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

    UserAccount user = userRepository.findByEmail(email)
        .orElseThrow(() -> new UsernameNotFoundException("User not found with email : " + email));

    return UserPrincipal.create(user);
  }

  public UserDetails loadUserById(int id) {
    UserAccount user = userRepository.findById(id).orElseThrow(
        () -> new ResourceNotFoundException("User", "id", id));

    return UserPrincipal.create(user);
  }
}