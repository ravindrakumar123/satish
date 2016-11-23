package com.visog.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.visog.springmvc.dao.EmployeeDao;
import com.visog.springmvc.model.Employee;

@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao dao;
	
	public Employee findById(int id) {
		return dao.findById(id);
	}

	public void saveEmployee(Employee employee) {
		dao.saveEmployee(employee);
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db once transaction ends. 
	 */
	public void updateEmployee(Employee employee) {
		Employee entity = dao.findById(employee.getId());
		if(entity!=null){
			entity.setName(employee.getName());
			entity.setDateOfBirth(employee.getDateOfBirth());
			entity.setEmail(employee.getEmail());
			entity.setPassword(employee.getPassword());
		}
	}

	public void deleteEmployeeBySsn(String password) {
		dao.deleteEmployeeByPassword(password);
	}
	
	public List<Employee> findAllEmployees() {
		return dao.findAllEmployees();
	}

	public Employee findEmployeeByPassword(String password) {
		return dao.findEmployeeByPassword(password);
	}

	public boolean isEmployeePasswordUnique(Integer id, String password) {
		Employee employee = findEmployeeByPassword(password);
		return ( employee == null || ((id != null) && (employee.getId() == id)));
	}

	@Override
	public void deleteEmployeeByPassword(String password) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loginEmployee(String name, String password) {
		// TODO Auto-generated method stub
		
	}
	
}
