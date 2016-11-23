package com.visog.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.visog.springmvc.model.Employee;

@Repository("employeeDao")
public class EmployeeDaoImpl extends AbstractDao<Integer, Employee> implements EmployeeDao {

	public Employee findById(int id) {
		return getByKey(id);
	}

	public void saveEmployee(Employee employee) {
		persist(employee);
	}
	
	/*public void loginEmployee(String name, String password){
		
	}*/

	public void deleteEmployeeByPassword(String password) {
		Query query = getSession().createSQLQuery("delete from Employee where password = :password");
		query.setString("password", password);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<Employee> findAllEmployees() {
		Criteria criteria = createEntityCriteria();
		return (List<Employee>) criteria.list();
	}

	public Employee findEmployeeByPassword(String password) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("password", password));
		return (Employee) criteria.uniqueResult();
	}
	
	public void loginEmployee(String name, String password){
		
	}
}
