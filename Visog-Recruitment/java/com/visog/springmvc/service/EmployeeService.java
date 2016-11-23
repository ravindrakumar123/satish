package com.visog.springmvc.service;

import java.util.List;

import com.visog.springmvc.model.Employee;

public interface EmployeeService {

	Employee findById(int id);
	
	void saveEmployee(Employee employee);
	
	void updateEmployee(Employee employee);
	
	void deleteEmployeeByPassword(String password);

	List<Employee> findAllEmployees(); 
	
	Employee findEmployeeByPassword(String password);

	boolean isEmployeePasswordUnique(Integer id, String password);
	
	void loginEmployee(String name, String password);
}
