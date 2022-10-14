package com.abcjob.test;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.abcjob.config.JpaConfig;
import com.abcjob.config.WebConfig;
import com.abcjob.dao.SearchProfileRepository;
import com.abcjob.entity.SearchProfile;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {WebConfig.class, JpaConfig.class})
public class SearchUserTest {
	
	@Autowired
	SearchProfileRepository repo;
	
	@Test
	public void searchUserTest() {
		List<SearchProfile> listUser = repo.search("alex");
		
		assertNotNull(listUser);
	}
}
