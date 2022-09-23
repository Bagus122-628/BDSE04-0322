package com.abcjob.login;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LoginService {
	
	@Autowired
	UserRepositoryLogin userRepo;
	
	@Autowired
	ProfileRepositoryLogin profileRepo;

	public LoginUser loadUserByEmail(String email) {
		LoginUser user = userRepo.findByEmail(email);
		return user;
	}
	
	public LoginProfile loadProfile(LoginUser user) {
		LoginProfile profile = user.getProfile();
		return profile;
	}
	
	public LoginUser loginUser(String email, String password) {
		LoginUser user = userRepo.findByEmail(email);
		
		if(user.getPassword().equals(password)) {
			return user;
		}
		
		return null;
	}
	
	public LoginProfile getCurrentUser(HttpSession session) {
		LoginProfile profile = (LoginProfile) session.getAttribute("profile");
		if(profile != null) {
			System.out.println("User " + profile.getFirst_name());
		}
		return profile;
	}

}
