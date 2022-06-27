package com.pepcus.productmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pepcus.productmanagement.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

  @Query("select p from Product p where p.departmentId = :id ")
  public List<Product> getAllProductBasedOnDepartmentid(@Param(value = "id") int id);
  @Query("SELECT p FROM Product p WHERE p.date BETWEEN '2021-03-01 11:00:00' AND '2022-03-01 22:00:00' order by date desc")
  public List<Product> getAllProduct();
}


