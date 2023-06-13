package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Customer;
import com.example.demo.entities.Expert;
import com.example.demo.entities.Login;
import com.example.demo.entities.Requirement;

@Repository
public interface RequirementRepository extends JpaRepository<Requirement, Integer> 
{
	@Query("select r from Requirement r where exp_id = :e")
	public List<Requirement> getRequirementByExperts(Expert e);
}
