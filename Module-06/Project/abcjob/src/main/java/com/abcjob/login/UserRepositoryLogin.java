package com.abcjob.login;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryLogin extends JpaRepository<LoginUser, Integer>{

	LoginUser findByEmail(String email);
}
