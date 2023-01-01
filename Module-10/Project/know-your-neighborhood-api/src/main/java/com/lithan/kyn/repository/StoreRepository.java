package com.lithan.kyn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lithan.kyn.entity.Store;

public interface StoreRepository extends JpaRepository<Store, Integer> {

  @Query(value = "DELETE FROM tb_store WHERE store_id = :store_id", nativeQuery = true)
  void deleteStore(@Param("store_id") int storeId);
}
