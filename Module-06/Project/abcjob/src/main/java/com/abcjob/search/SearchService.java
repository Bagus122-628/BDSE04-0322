package com.abcjob.search;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SearchService {
	
	@Autowired
	ProfileRepositorySearch profileRepo;
	
	public List<SearchProfile> search(String keyword){
		 return profileRepo.search(keyword);
	}
	
	public SearchProfile loadUserById(int id) {
		SearchProfile profile = profileRepo.findById(id).get();
		return profile;
	}
}
