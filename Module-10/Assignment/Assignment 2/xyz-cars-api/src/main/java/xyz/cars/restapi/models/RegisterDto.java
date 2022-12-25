package xyz.cars.restapi.models;

import javax.validation.constraints.Size;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class RegisterDto {

  @NotBlank(message = "Username is required")
  private String username;

  @Size(min = 6, message = "Password must be at least 6 characters long")
  private String password;
}