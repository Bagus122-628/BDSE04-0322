package com.abcjob.register;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterProfileRepository extends JpaRepository<RegisterProfile, Integer>{

}
