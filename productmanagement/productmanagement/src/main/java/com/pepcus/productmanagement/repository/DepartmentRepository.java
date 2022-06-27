package com.pepcus.productmanagement.repository;

import org.springframework.data.repository.CrudRepository;

import com.pepcus.productmanagement.model.Department;

public interface DepartmentRepository extends CrudRepository<Department, Integer>{

}
