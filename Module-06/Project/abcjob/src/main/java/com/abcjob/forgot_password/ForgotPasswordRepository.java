package com.abcjob.forgot_password;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ForgotPasswordRepository extends JpaRepository<ForgotPasswordUser, Integer>{
	ForgotPasswordUser findByEmail(String email);
}
