package com.abcjob.search;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProfileRepositorySearch extends JpaRepository<SearchProfile, Integer>{
	
	@Query(value="SELECT UP.id_profile, UP.id_job, UP.first_name, UP.last_name, UP.country, UP.city, J.id_job, J.company_name "
			+ "FROM tb_user_profile AS UP "
			+ "LEFT JOIN tb_jobs AS J ON UP.id_job = J.id_job "
			+ "WHERE UP.first_name LIKE '%' :keyword '%' "
			+ "OR UP.last_name LIKE '%' :keyword '%' "
			+ "OR UP.country LIKE '%' :keyword '%' "
			+ "OR UP.city LIKE '%' :keyword '%' "
			+ "OR J.company_name LIKE '%' :keyword '%';",
			nativeQuery = true)
	public List<SearchProfile> search(@Param("keyword") String keyword);
}
