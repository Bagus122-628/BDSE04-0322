package com.abcjob.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RegisterService {
	
	@Autowired
	ProfileRepository profileRepo;
	
	public void saveRegister(RegisterUser regUser) {
		RegisterUser user = new RegisterUser();
		RegisterProfile profile = new RegisterProfile();
		
		RegisterUser userRegister = new RegisterUser(regUser.getEmail(), regUser.getPassword(), profile);
		RegisterProfile userProfile = new RegisterProfile(user, 
				regUser.getProfile().getFirst_name(), 
				regUser.getProfile().getLast_name(), 
				regUser.getProfile().getCountry(), 
				regUser.getProfile().getCity());
		
		userRegister.setProfile(userProfile);
		userProfile.setUser(userRegister);
		
		profileRepo.save(userProfile);
	}
	
}
