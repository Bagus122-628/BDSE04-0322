package com.lithan.a5.config;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lithan.a5.entity.Users;
import com.lithan.a5.repository.UsersRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

  @Autowired
  private UsersRepository userRepo;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    Users user = userRepo.findByUsername(username);

    if (user != null) {
      return new User(user.getUsername(), user.getPassword(),
          user.getRoles().stream().map((userRole -> new SimpleGrantedAuthority(userRole.getRole())))
              .collect(Collectors.toList()));
    } else {
      throw new UsernameNotFoundException("Invalid username or password");
    }
  }
}