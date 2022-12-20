package xyz.cars.restapi.models;

import lombok.Data;

@Data
public class LoginDto {
  private String username;
  private String password;
}
