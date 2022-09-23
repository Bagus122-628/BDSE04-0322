package com.abcjob.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abcjob.admin.entity.Job;

public interface JobRepository extends JpaRepository<Job, Integer>{

}
