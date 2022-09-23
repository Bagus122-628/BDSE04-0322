package com.abcjob.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.abcjob.search.SearchProfile;
import com.abcjob.search.SearchService;

public class SearchServiceTest {
	
	@Autowired
	SearchService searchService;
	
	@Test
	public void searchTest() {
		List<SearchProfile> result = searchService.search("alex");
		
		assertNotNull(result);
	}
}
