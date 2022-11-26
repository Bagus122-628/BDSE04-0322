package com.lithan.a3.service;

import java.util.List;

import com.lithan.a3.entity.Store;

public interface StoreRepository {
	
	public void save(Store store);
	
	public List<Store> listAll();
}
