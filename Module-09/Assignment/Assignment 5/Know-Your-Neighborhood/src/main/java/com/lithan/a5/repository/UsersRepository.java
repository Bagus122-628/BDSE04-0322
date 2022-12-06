package com.lithan.a5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lithan.a5.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

  public Users findByUsername(String username);
}