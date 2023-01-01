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
public class StoreDto {

  private int storeId;

  private String storeName;

  private String country;

  private String city;

  private String storeEmail;

  private String phoneNumber;

  private int userId;
}
