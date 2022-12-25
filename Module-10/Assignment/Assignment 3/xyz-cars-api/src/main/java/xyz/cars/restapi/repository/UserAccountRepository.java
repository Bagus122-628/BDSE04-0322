package xyz.cars.restapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import xyz.cars.restapi.entity.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount, Integer> {

  public Optional<UserAccount> findByEmail(String email);

  Boolean existsByEmail(String email);
}
