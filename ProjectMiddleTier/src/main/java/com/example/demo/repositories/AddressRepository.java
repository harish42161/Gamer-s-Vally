package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Address;
import com.example.demo.entities.Area;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> 
{
	@Query("select a from Address a where area_id= :id")
	public Address getAddressByArea(Area id);
}
