package com.lithan.a5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lithan.a5.entity.Store;
import com.lithan.a5.exception.StoreNotFoundException;
import com.lithan.a5.repository.StoreRepository;

@Service
public class StoreServiceImpl implements StoreService {

	@Autowired
	private StoreRepository storeRepo;

	@Override
	public void addStore(Store store) {

		storeRepo.save(store);
	}

	@Override
	public List<Store> listStore() {

		List<Store> listStore = storeRepo.findAll();

		return listStore;
	}

	@Override
	public Store editStore(Store store) {
		Store editedStore = storeRepo.findById(store.getId_store()).get();

		editedStore.setName(store.getName());
		editedStore.setPhone_number(store.getPhone_number());
		editedStore.setLocalities(store.getLocalities());

		storeRepo.save(editedStore);

		return editedStore;
	}

	@Override
	public void deleteStore(int id) {

		storeRepo.deleteById(id);
	}

	@Override
	public Store findById(int id) {
		Store store = storeRepo.findById(id).get();

		return store;
	}

	@Override
	public List<Store> search(String keyword) throws StoreNotFoundException {
		List<Store> listStore = storeRepo.search(keyword);

		return listStore;
	}

}
