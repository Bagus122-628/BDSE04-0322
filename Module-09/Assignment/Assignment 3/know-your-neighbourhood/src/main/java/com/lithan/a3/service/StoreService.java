package com.lithan.a3.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lithan.a3.entity.Store;

@Service
public class StoreService implements StoreRepository {
	
	private List<Store> stores = new ArrayList<Store>();

	@Override
	public void save(Store store) {
		stores.add(store);
	}

	@Override
	public List<Store> listAll() {
		return stores;
	}

}
