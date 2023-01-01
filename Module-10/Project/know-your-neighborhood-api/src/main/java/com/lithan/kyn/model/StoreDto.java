package com.lithan.kyn.model;

import com.lithan.kyn.entity.Store;

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

  private UserDto user;

  public StoreDto(Store store) {
    this.storeId = store.getStoreId();
    this.storeName = store.getStoreName();
    this.country = store.getCountry();
    this.city = store.getCity();
    this.storeEmail = store.getStoreEmail();
    this.phoneNumber = store.getPhoneNumber();
    this.user = new UserDto(store.getUser());
  }

}
