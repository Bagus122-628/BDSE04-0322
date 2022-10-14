package com.abcjob.test;

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
import com.abcjob.entity.UserProfile;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {WebConfig.class, JpaConfig.class})
public class RegisterTest {
	
	@Autowired
	UserRepository userRepo;
	
	@Test
	public void registerTest() {
		
		int random = (int)(Math.random() * 1000) +1;
		String email = "unittest" + random + "@email.com";
		
		User user = new User();
		user.setEmail(email);
		user.setPassword("password");
		user.setEnabled(true);
		
		UserProfile profile = new UserProfile();
		profile.setFirst_name("test");
		profile.setLast_name("test");
		profile.setCountry("test");
		profile.setCity("test");
		
		profile.setUser(user);
		user.setProfile(profile);
		
		User testUser = userRepo.save(user);
		
		assertEquals(email, testUser.getEmail());
	}
}
