package com.lithan.a5.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lithan.a5.entity.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Integer> {
  @Query(value = "SELECT * FROM tb_store WHERE name LIKE '%' :keyword '%'", nativeQuery = true)
  public List<Store> search(@Param("keyword") String keyword);
}
