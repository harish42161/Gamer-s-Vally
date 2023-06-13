package com.example.demo.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Distributor;
import com.example.demo.entities.Expert;
import com.example.demo.entities.Login;

@Transactional
@Repository
public interface DistributorRepository extends JpaRepository<Distributor, Integer> {

	@Query("select d from Distributor d where login_id = :l")
	public Distributor getDistributor(Login l);
	
	@Modifying
	@Query("update Distributor set picture = :file where distri_id = :id")
	public int uploadPicture(int id,byte[] file);
	
	@Query(value = "SELECT * FROM Distributor d where d.login_id in (SELECT login_id FROM Login l where l.status = 0) ", nativeQuery = true)
	public List<Distributor> viewRegistrationReqOfDistri();
}
