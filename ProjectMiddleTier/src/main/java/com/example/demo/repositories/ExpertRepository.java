package com.example.demo.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Brand;
import com.example.demo.entities.Category;
import com.example.demo.entities.Expert;
import com.example.demo.entities.Login;

@Transactional
@Repository
public interface ExpertRepository extends JpaRepository<Expert, Integer> {

		@Query("select e from Expert e where login_id = :l")
		public Expert getExpert(Login l);
		
		@Modifying
		@Query("update Expert set picture = :file where exp_id = :id")
		public int uploadPicture(int id,byte[] file);
		
		@Query("select e.picture from Expert e where exp_id = :e")
		public byte[] getExpImage(int e);
		
		@Query(value = "SELECT * FROM Expert e where e.login_id in (SELECT login_id FROM Login l where l.status = 0) ", nativeQuery = true)
		public List<Expert> viewRegistrationReqOfExp();
		
		

}
