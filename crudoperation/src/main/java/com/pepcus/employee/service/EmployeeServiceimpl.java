package com.pepcus.employee.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pepcus.employee.modal.Employee;
import com.pepcus.employee.repository.EmployeeRepositoy;

@Service
public class EmployeeServiceimpl implements EmployeeService {
	@Autowired
	EmployeeRepositoy employeeRepositoy;

	@Override
	public Employee addemployee(Employee employee) {
		
		return employeeRepositoy.save(employee);
	}

	@Override
	public List<Employee> getEmployee() {
		List<Employee> emplist=(List<Employee>)employeeRepositoy.findAll(); 
		return emplist;
	}

	@Override
	public String deleteEmployee(int id) {
	    try {
	    	employeeRepositoy.deleteById(id);
	    }catch(Exception e) {
	    	return "employee id not found"+id;
	    }
		return "employee delete successfully"+id;
	}



	}

