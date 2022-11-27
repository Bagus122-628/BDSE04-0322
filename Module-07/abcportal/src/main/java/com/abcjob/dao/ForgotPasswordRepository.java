package com.abcjob.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abcjob.entity.User;

@Repository
public interface ForgotPasswordRepository extends JpaRepository<User, Integer> {
	User findByEmail(String email);
}
