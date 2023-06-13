package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Response;

@Repository
public interface ResponseRepository extends JpaRepository<Response, Integer> 
{

}
