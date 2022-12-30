package com.lithan.kyn.service;

import com.lithan.kyn.entity.ERole;
import com.lithan.kyn.entity.Roles;

public interface UserService {

  Roles createRole(ERole roleName);
}
