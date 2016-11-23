package com.visog.springmvc.dao;

import java.util.List;

import com.visog.springmvc.model.Employee;

public interface EmployeeDao {

	Employee findById(int id);

	void saveEmployee(Employee employee);
	
	void loginEmployee(String name, String password);
	
	void deleteEmployeeByPassword(String password);
	
	List<Employee> findAllEmployees();

	Employee findEmployeeByPassword(String password);

}
