package com.lithan.a2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lithan.a2.entity.Store;
import com.lithan.a2.repo.StoreRepository;

@Service
@Transactional
public class StoreServiceImpl implements StoreService {
	
	@Autowired
	private StoreRepository storeRepo;

	public void addStore(Store store) {
		
		storeRepo.save(store);
	}

}
