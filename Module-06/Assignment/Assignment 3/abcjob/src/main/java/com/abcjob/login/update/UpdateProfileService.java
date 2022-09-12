package com.abcjob.login.update;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abcjob.login.LoginProfile;
import com.abcjob.login.ProfileRepositoryLogin;

@Service
@Transactional
public class UpdateProfileService {

	@Autowired
	ProfileRepositoryLogin profileRepo;
	
	public LoginProfile getProfileById(int id) {
		return profileRepo.findById(id).get();
	}
	
	public LoginProfile saveEdit(LoginProfile logProfile) {
		LoginProfile profile = getProfileById(logProfile.getId_profile());
		
		profile.setFirst_name(logProfile.getFirst_name());
		profile.setLast_name(logProfile.getLast_name());
		profile.setCountry(logProfile.getCountry());
		profile.setCity(logProfile.getCity());
		
		profileRepo.save(profile);
		
		return profile;
	}
}
