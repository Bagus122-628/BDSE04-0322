package com.lithan.kyn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lithan.kyn.entity.Store;
import com.lithan.kyn.entity.UserAccount;
import com.lithan.kyn.model.StoreDto;
import com.lithan.kyn.repository.StoreRepository;
import com.lithan.kyn.repository.UserAccountRepository;

@Service
public class StoreServiceImpl implements StoreService {

  @Autowired
  private StoreRepository storeRepo;

  @Autowired
  private UserAccountRepository userRepo;

  @Override
  public List<Store> listStore() {

    List<Store> listStore = storeRepo.findAll();

    return listStore;
  }

  @Override
  public Store getStoreById(int storeId) {

    return storeRepo.findById(storeId).get();
  }

  @Override
  public Store addStore(StoreDto storeDto) {
    Store store = new Store();
    UserAccount user = userRepo.findById(storeDto.getUserId()).get();

    store.setStoreName(storeDto.getStoreName());
    store.setCountry(storeDto.getCountry());
    store.setCity(storeDto.getCity());
    store.setStoreEmail(storeDto.getStoreEmail());
    store.setPhoneNumber(storeDto.getPhoneNumber());

    store.setUser(user);

    return storeRepo.save(store);
  }

  @Override
  public Store editStore(StoreDto storeDto) {
    Store store = storeRepo.findById(storeDto.getStoreId()).get();

    store.setStoreName(storeDto.getStoreName());
    store.setCountry(storeDto.getCountry());
    store.setCity(storeDto.getCity());
    store.setStoreEmail(storeDto.getStoreEmail());
    store.setPhoneNumber(storeDto.getPhoneNumber());

    return storeRepo.save(store);
  }

}
