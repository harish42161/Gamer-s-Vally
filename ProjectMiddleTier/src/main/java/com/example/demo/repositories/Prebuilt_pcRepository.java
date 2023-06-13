package com.example.demo.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Expert;
import com.example.demo.entities.Prebuilt_pc;

@Transactional
@Repository
public interface Prebuilt_pcRepository extends JpaRepository<Prebuilt_pc, Integer> {

	@Query("select p from Prebuilt_pc p where exp_id = :e")
	public List<Prebuilt_pc> getPrebuilt_pcByExperts(Expert e);
	
	
	@Modifying
	@Query("delete from Prebuilt_pc p where p.pc_id = :e")
	public int deletePrebuilt_pc(int e);
}
