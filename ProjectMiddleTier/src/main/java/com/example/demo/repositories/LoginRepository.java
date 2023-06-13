package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Brand;
import com.example.demo.entities.Category;
import com.example.demo.entities.Login;

@Transactional
@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> 
{
	@Query("select l from Login l where email= :email and pwd= :pwd")
	public Optional<Login> getLogin(String email,String pwd);
	
	/*@Query("select l from Login l where role_id = 4 and status = 0")
	public List<Login> viewRegistrationReqOfExp();*/
	
	@Modifying
	@Query("update Login set status = 1 where login_id = :l")
	public int approveUser(int l);
	
	@Modifying
	@Query("update Login set status = 0 where login_id = :l")
	public int pendingUser(int l);
}
