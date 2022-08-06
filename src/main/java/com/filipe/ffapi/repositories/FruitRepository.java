package com.filipe.ffapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.filipe.ffapi.models.FruitModel;

@Repository
public interface FruitRepository extends JpaRepository<FruitModel, Long>{
	
	@Query("SELECT obj FROM FruitModel obj WHERE obj.name =:name")
	FruitModel findByName(@Param("name") String name);

}
 