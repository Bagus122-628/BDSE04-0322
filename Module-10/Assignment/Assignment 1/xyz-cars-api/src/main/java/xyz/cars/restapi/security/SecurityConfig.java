package xyz.cars.restapi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public static PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    // Authorize
    http.authorizeRequests()
        .antMatchers(HttpMethod.GET).permitAll()
        .antMatchers("/api/users/register").permitAll()
        .antMatchers(HttpMethod.POST).authenticated();

    http.cors().and().csrf().disable();

    // Form Login
    http.httpBasic()
        .and()
        .formLogin()
        .permitAll();

    // Logout
    http.logout()
        .permitAll();

    return http.build();
  }

}
