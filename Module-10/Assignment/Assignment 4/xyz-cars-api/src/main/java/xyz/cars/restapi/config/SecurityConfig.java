package xyz.cars.restapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import xyz.cars.restapi.oauth2.CustomOAuth2UserService;
import xyz.cars.restapi.oauth2.HttpCookieOAuth2AuthorizationRequestRepository;
import xyz.cars.restapi.oauth2.OAuth2AuthenticationFailureHandler;
import xyz.cars.restapi.oauth2.OAuth2AuthenticationSuccessHandler;
import xyz.cars.restapi.security.JWTAuthEntryPoint;
import xyz.cars.restapi.security.JWTAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, jsr250Enabled = true, prePostEnabled = true)
public class SecurityConfig {

  @Autowired
  private JWTAuthEntryPoint authEntryPoint;

  @Autowired
  private CustomOAuth2UserService customOAuth2UserService;

  @Autowired
  private OAuth2AuthenticationSuccessHandler oAuth2AuthenticationSuccessHandler;

  @Autowired
  private OAuth2AuthenticationFailureHandler oAuth2AuthenticationFailureHandler;

  @Bean
  public static PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    http.cors().and().csrf().disable()
        // Exception Handling
        .exceptionHandling()
        .authenticationEntryPoint(authEntryPoint)
        .and()

        // Session Management
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()

        // Authorize Requests
        .authorizeRequests()
        .antMatchers("/oauth2/**").permitAll()
        .antMatchers("/api/auth/**").permitAll()
        .antMatchers("/api/cars/**").permitAll()
        .antMatchers("/api/messages/**").permitAll()

        .antMatchers("/api/cars/post").authenticated()
        .antMatchers("/api/users/me").authenticated()
        .and()

        // Login
        .httpBasic()
        .disable()
        .formLogin()
        .disable()

        .oauth2Login()
        .authorizationEndpoint()
        .baseUri("/oauth2/authorize")
        .authorizationRequestRepository(cookieAuthorizationRequestRepository())
        .and()

        .redirectionEndpoint()
        .baseUri("/oauth2/callback/*")
        .and()

        .userInfoEndpoint()
        .userService(customOAuth2UserService)
        .and()

        .successHandler(oAuth2AuthenticationSuccessHandler)
        .failureHandler(oAuth2AuthenticationFailureHandler);

    http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    return http.build();
  }

  @Bean
  public AuthenticationManager authenticationManager(
      AuthenticationConfiguration authenticationConfiguration) throws Exception {
    return authenticationConfiguration.getAuthenticationManager();
  }

  @Bean
  public JWTAuthenticationFilter jwtAuthenticationFilter() {
    return new JWTAuthenticationFilter();
  }

  @Bean
  public HttpCookieOAuth2AuthorizationRequestRepository cookieAuthorizationRequestRepository() {
    return new HttpCookieOAuth2AuthorizationRequestRepository();
  }

}
