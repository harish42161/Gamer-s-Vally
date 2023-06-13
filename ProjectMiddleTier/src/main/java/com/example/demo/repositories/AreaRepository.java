package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Area;
import com.example.demo.entities.City;

@Repository
public interface AreaRepository extends JpaRepository<Area, Integer> {

	@Query("select a from Area a where area_id = :l")
	public List<Area> getById(Area l);
	
	@Query("select a from Area a where city_id = :c")
	public List<Area> getAll(City c);
}
