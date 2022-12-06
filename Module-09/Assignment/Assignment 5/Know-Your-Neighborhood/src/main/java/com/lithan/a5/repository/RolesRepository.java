package com.lithan.a5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lithan.a5.entity.Roles;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Integer> {

  public Roles findByRole(String role);
}