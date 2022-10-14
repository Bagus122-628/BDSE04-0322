package com.abcjob.search;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abcjob.dao.SearchProfileRepository;
import com.abcjob.dao.UserProfileRepository;
import com.abcjob.entity.SearchProfile;
import com.abcjob.entity.UserProfile;

@Service
@Transactional
public class SearchService {

	@Autowired
	UserProfileRepository profileRepo;
	
	@Autowired
	SearchProfileRepository searchRepo;

	public List<SearchProfile> search(String keyword) {
		return searchRepo.search(keyword);
	}

	public UserProfile loadUserById(int id) {
		UserProfile profile = profileRepo.findById(id).get();
		return profile;
	}
}
