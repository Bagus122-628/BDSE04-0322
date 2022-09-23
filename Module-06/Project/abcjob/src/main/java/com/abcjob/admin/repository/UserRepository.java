package com.abcjob.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abcjob.admin.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
