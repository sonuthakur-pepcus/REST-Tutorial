package com.pepcus.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.pepcus.employee.modal.Employee;
import com.pepcus.employee.repository.AddressRepository;
import com.pepcus.employee.repository.EmployeeRepositoy;

@Service
public class EmployeeServiceimpl  {
	@Autowired
	 private EmployeeRepositoy employeeRepositoy;
	 @Autowired
     private AddressRepository addressRepository;
	 
	public Employee addemployee(Employee employee) {
		addressRepository.saveAll(employee.getAddress());
		return employeeRepositoy.save(employee);
	}

	
	public List<Employee> getEmployee() {
		List<Employee> emplist=(List<Employee>)employeeRepositoy.findAll(); 
		return emplist;
	}

	
	public String deleteEmployee(int id) {
	    try {
	    	employeeRepositoy.deleteById(id);
	    }catch(Exception e) {
	    	return "employee id not found"+id;
	    }
		return "employee delete successfully"+id;
	}


	public Employee updateEmployee(Employee employee) {
		
		return employeeRepositoy.save(employee);
	}


	public List<Employee> findAllOrderByNameAsc() {
	     
		return employeeRepositoy.findAllOrderByNameAsc();
	}
	
} 

