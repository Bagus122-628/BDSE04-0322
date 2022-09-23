package com.abcjob.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.abcjob.login.LoginService;
import com.abcjob.register.RegisterProfile;
import com.abcjob.register.RegisterService;
import com.abcjob.register.RegisterUser;

@ExtendWith(MockitoExtension.class)
public class RegisterServiceTest {
	
	@Mock
	RegisterService registerService;
	
	@Mock
	LoginService loginService;
	
	@Test
	public void registerTest() {
		RegisterUser user = new RegisterUser();
		RegisterProfile profile = new RegisterProfile();
		
		user.setEmail("registertest01@email.com");
		user.setPassword("password");
		user.setEnabled(true);
		
		profile.setFirst_name("Test");
		profile.setLast_name("User");
		profile.setCountry("Country");
		profile.setCity("city");
		
		user.setProfile(profile);
		
		assertTrue(registerService.saveRegister(user));
		assertNotNull(loginService.loadUserByEmail(user.getEmail()));

	}
}
