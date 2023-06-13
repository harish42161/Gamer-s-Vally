package com.example.demo.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Brand;
import com.example.demo.entities.Category;
import com.example.demo.entities.Product;

@Transactional
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> 
{
	@Modifying
	@Query("update Product set cat_id = :cat_id,brand_id = :brand_id,description = :description")
	public int addProduct(Category cat_id,Brand brand_id,String description);
	
	@Query("select p from Product p where cat_id = 1 ")
	public List<Product> getAllMonitors();
	
	@Query("select p from Product p where cat_id = 2 ")
	public List<Product> getAllMouse();
	
	@Query("select p from Product p where cat_id = 3 ")
	public List<Product> getAllGraphics_card();
	
	@Query("select p from Product p where cat_id = 4 ")
	public List<Product> getAllKeyboards();
	
	@Query("select p from Product p where cat_id = 5 ")
	public List<Product> getAllCabinets();
	
	@Query("select p from Product p where cat_id = 6 ")
	public List<Product> getAllMotherboards();
	
	@Query("select p from Product p where cat_id = 7 ")
	public List<Product> getAllStorage();
	
	@Query("select p from Product p where cat_id = 8 ")
	public List<Product> getAllGaming_chairs();
	
	
	
	@Modifying
	@Query("update Product set picture = :file where prod_id = :id")
	public int uploadProductPicture(int id,byte[] file);
}
