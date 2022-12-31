package com.lithan.kyn.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.lithan.kyn.entity.ERole;
import com.lithan.kyn.entity.Roles;
import com.lithan.kyn.repository.RolesRepository;

@Component
public class DataLoader implements ApplicationRunner {

  @Autowired
  private RolesRepository rolesRepo;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    if (rolesRepo.findByName(ERole.ROLE_VIEW_STORE) == null) {
      rolesRepo.save(new Roles(ERole.ROLE_VIEW_STORE));
    }

    if (rolesRepo.findByName(ERole.ROLE_ADD_STORE) == null) {
      rolesRepo.save(new Roles(ERole.ROLE_ADD_STORE));
    }
  }
}
