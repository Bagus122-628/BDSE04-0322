package com.lithan.a4.service;

import java.util.List;

import com.lithan.a4.entity.Store;

public interface StoreService {

  public void addStore(Store store);

  public Store findById(int id);

  public List<Store> listStore();

  public Store editStore(Store store);

  public void deleteStore(int id);
}
