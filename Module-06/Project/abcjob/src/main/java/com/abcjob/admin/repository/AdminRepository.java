package com.abcjob.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abcjob.admin.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
	
	Admin findByEmail(String email);
}
