package com.pepcus.employee.service;

import java.util.List;

import com.pepcus.employee.modal.Employee;

public interface EmployeeService {

	Employee addemployee(Employee employee);

	List<Employee> getEmployee();

	String deleteEmployee(int id);

	

}

