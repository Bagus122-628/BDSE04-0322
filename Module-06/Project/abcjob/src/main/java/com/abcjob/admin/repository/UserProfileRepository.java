package com.abcjob.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abcjob.admin.entity.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, Integer>{

}
