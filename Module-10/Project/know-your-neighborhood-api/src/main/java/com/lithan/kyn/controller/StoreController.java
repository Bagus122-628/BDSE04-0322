package com.lithan.kyn.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lithan.kyn.entity.Store;
import com.lithan.kyn.model.ApiResponse;
import com.lithan.kyn.model.StoreDto;
import com.lithan.kyn.service.StoreService;

@RestController
@RequestMapping("/api/stores")
public class StoreController {

  @Autowired
  private StoreService storeService;

  @GetMapping("")
  public List<Store> listStore() {

    return storeService.listStore();
  }

  @PostMapping("/add")
  public ResponseEntity<?> addStore(@RequestBody StoreDto storeDto) {

    Store newStore = storeService.addStore(storeDto);

    URI location = ServletUriComponentsBuilder
        .fromCurrentContextPath().path("api/stores/{storeId}")
        .buildAndExpand(newStore.getStoreId()).toUri();

    return ResponseEntity.created(location)
        .body(new ApiResponse(true, "Store successfully added"));
  }

  @GetMapping("/{storeId}")
  public Store getStoreById(@PathVariable("storeId") int storeId) {
    Store store = storeService.getStoreById(storeId);

    return store;
  }

  @PutMapping("/edit")
  public StoreDto editStore(@RequestBody StoreDto storeDto) {
    Store store = storeService.editStore(storeDto);

    return new StoreDto(
        store.getStoreId(),
        store.getStoreName(),
        store.getCountry(),
        store.getCity(),
        store.getStoreEmail(),
        store.getPhoneNumber(),
        store.getUser().getUserId());
  }

}
