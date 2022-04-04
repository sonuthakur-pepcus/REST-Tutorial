package com.pepcus.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pepcus.employee.modal.Employee;
import com.pepcus.employee.service.EmployeeService;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

@PostMapping("/addEmployee")
public Employee addemployee(@RequestBody Employee employee) {
	Employee emp=employeeService.addemployee(employee);
	return emp;		
}

@GetMapping("/getemployee")
public List<Employee> getEmployee() {
	List<Employee> emp1=employeeService.getEmployee();
	return emp1;
}
@PutMapping("/update")
public Employee updateEmployee(@RequestBody Employee employee) {
	Employee emp2=employeeService.addemployee(employee);
	return emp2;
}
@DeleteMapping("/delete/{id}")
public String deleteEmployee(@PathVariable("id") int id) {
	String success=employeeService.deleteEmployee(id);
	return success;
}
}



