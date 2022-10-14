package com.abcjob.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.abcjob.config.JpaConfig;
import com.abcjob.config.WebConfig;
import com.abcjob.dao.UserRepository;
import com.abcjob.entity.User;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {WebConfig.class, JpaConfig.class})
public class LoginTest {
	
	@Autowired
	UserRepository repo;
	
	@Test
	public void loginTest() {
		String email = "emailtest@email.com";
		String password = "password123";
		
		User user = repo.findByEmail(email);
		
		assertEquals(password, user.getPassword());
		assertTrue(user.getEnabled());
		assertNotNull(user);
	}
}
