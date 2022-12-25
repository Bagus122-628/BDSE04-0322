package xyz.cars.restapi.models;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;
import xyz.cars.restapi.entity.UserAccount;

@Data
@NoArgsConstructor
public class LoginDto {

  private int idUser;

  @NotBlank(message = "Username is required")
  private String username;

  @NotBlank(message = "Password is required")
  private String password;

  public LoginDto(UserAccount user) {
    this.idUser = user.getIdUser();
    this.username = user.getUsername();
  }
}
