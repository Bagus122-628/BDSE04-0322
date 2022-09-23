package com.abcjob.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ContextConfiguration;

import com.abcjob.config.ViewRes;
import com.abcjob.login.LoginService;
import com.abcjob.login.LoginUser;

@ExtendWith(MockitoExtension.class)
@ContextConfiguration(classes = {ViewRes.class})
public class LoginServiceTest {
	
	@Mock
	LoginService loginService;
	
	@Test
	public void loginTest() {
		String email = "sulivan@email.com";
		String password = "password123";
		
		LoginUser user = loginService.loginUser(email, password);
		assertNotNull(user);
	}
}
