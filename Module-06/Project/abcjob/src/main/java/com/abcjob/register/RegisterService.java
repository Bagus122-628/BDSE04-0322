package com.abcjob.register;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

@Service
@Transactional
@RestController
public class RegisterService {
	
	@Autowired
	RegisterUserRepository userRepo;
	
	@Autowired
	RegisterProfileRepository profileRepo;
	
	@Autowired
	RegisterJobRepository jobRepo;
	
	public boolean saveRegister(RegisterUser regUser) {
		RegisterUser user = new RegisterUser();
		RegisterProfile profile = new RegisterProfile();
		
		RegisterUser userRegister = new RegisterUser(regUser.getEmail(), regUser.getPassword(), false, profile);
		RegisterProfile userProfile = new RegisterProfile(user,
				regUser.getProfile().getJob(),
				regUser.getProfile().getFirst_name(), 
				regUser.getProfile().getLast_name(), 
				regUser.getProfile().getCountry(), 
				regUser.getProfile().getCity());
		
		userRegister.setProfile(userProfile);
		userProfile.setUser(userRegister);
		
		profileRepo.save(userProfile);
		
		return true;
	}
	
	public List<RegisterJob> listJob(){
		List<RegisterJob> listJob = jobRepo.findAll();
		return listJob;
	}
	
	public RegisterUser findUser(int id) {
		RegisterUser user = userRepo.findById(id).get();
		return user;
	}
	
	public void userActivation(RegisterUser userActivation) {
		userRepo.save(userActivation);
	}

	
}
