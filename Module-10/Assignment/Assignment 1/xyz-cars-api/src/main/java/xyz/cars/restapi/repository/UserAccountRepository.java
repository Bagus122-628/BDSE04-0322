package xyz.cars.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import xyz.cars.restapi.entity.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount, Integer> {

  public UserAccount findByUsername(String username);
}
