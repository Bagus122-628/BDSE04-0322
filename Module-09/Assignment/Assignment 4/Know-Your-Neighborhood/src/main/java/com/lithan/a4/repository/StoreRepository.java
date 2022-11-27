package com.lithan.a4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lithan.a4.entity.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Integer> {

}
