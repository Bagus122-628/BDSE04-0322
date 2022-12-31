package com.lithan.kyn.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

  private int userId;

  private String name;

  private String email;

  private String imageUrl;

  private String address;

  private String phoneNumber;

}
