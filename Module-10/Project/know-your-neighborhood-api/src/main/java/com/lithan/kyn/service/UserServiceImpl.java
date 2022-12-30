package com.lithan.kyn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lithan.kyn.entity.ERole;
import com.lithan.kyn.entity.Roles;
import com.lithan.kyn.repository.RolesRepository;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private RolesRepository rolesRepo;

  @Override
  public Roles createRole(ERole roleName) {
    Roles role = new Roles();
    role.setName(ERole.ROLE_VIEW_STORE);
    return rolesRepo.save(role);
  }

}
