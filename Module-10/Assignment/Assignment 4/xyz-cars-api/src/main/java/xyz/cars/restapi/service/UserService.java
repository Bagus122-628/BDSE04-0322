package xyz.cars.restapi.service;

import java.util.List;

import xyz.cars.restapi.entity.UserAccount;

public interface UserService {

  List<UserAccount> listUser() throws Exception;

  UserAccount getUserById(int idUser) throws Exception;

}
