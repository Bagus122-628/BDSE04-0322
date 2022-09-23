package com.abcjob.forgot_password;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ForgotPasswordService {
	
	@Autowired
	ForgotPasswordRepository forgotPasswordRepo;
	
	public ForgotPasswordUser findUser(String email) {
		ForgotPasswordUser user = forgotPasswordRepo.findByEmail(email);
		return user;
	}
	
	public void forgotPassword(ForgotPasswordUser userFP) {
		userFP.setPassword("password123");
		forgotPasswordRepo.save(userFP);
	}
}
