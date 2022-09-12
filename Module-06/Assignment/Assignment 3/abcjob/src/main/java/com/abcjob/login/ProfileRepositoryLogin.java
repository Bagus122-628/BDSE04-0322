package com.abcjob.login;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepositoryLogin extends JpaRepository<LoginProfile, Integer>{

}
