package com.abcjob.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abcjob.entity.BulkEmail;

@Repository
public interface BulkEmailRepository extends JpaRepository<BulkEmail, Integer> {

}
