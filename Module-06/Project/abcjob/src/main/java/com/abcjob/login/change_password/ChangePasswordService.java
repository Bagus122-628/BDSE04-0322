package com.abcjob.login.change_password;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abcjob.login.LoginUser;
import com.abcjob.login.UserRepositoryLogin;

@Service
@Transactional
public class ChangePasswordService {
	
	@Autowired
	UserRepositoryLogin userRepo;
	
	public void changePassword(LoginUser user, String newPassword) {
		user.setPassword(newPassword);
		userRepo.save(user);
	}
}
