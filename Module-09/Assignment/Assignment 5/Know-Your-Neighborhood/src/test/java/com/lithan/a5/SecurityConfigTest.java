package com.lithan.a5;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfigTest {

  @Bean
  public InMemoryUserDetailsManager userDetailsManager() {

    UserDetails viewstore = User.builder()
        .username("viewstore")
        .password("{noop}viewstore")
        .roles("VIEW_STORE")
        .build();

    UserDetails addstore = User.builder()
        .username("ddstore")
        .password("{noop}ddstore")
        .roles("VIEW_STORE", "ADD_STORE")
        .build();

    return new InMemoryUserDetailsManager(viewstore, addstore);
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    // Authorize
    http.authorizeRequests(configurer -> configurer
        .antMatchers("/").permitAll()
        .antMatchers("/stores").hasRole("VIEW_STORE")
        .antMatchers("/addStore/**").hasRole("ADD_STORE")
        .antMatchers("/editStore/**").hasRole("ADD_STORE")
        .antMatchers("/deleteStore").hasRole("ADD_STORE"));

    // Form Login
    http.formLogin(form -> form
        .loginPage("/login")
        .loginProcessingUrl("/loginUser")
        .permitAll());

    // Logout
    http.logout(logout -> logout
        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
        .permitAll());

    return http.build();
  }
}