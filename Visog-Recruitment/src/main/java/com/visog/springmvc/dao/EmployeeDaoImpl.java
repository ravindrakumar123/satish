package com.visog.springmvc.dao;

import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.visog.springmvc.model.Student;

@Repository("employeeDao")
public class EmployeeDaoImpl extends AbstractDao<Integer, Student> implements EmployeeDao {
    
	DataSource dataSource;

	public DataSource getDataSource()
	{
			return this.dataSource;
	}

	public void setDataSource(DataSource dataSource)
	{	
			this.dataSource = dataSource;
	}
	
	public Student findById(int id) {
		return getByKey(id);
	}

	public void saveStudent(Student student) {
		persist(student);
	}

	public void deleteStudentByStuno(String stuno) {
		Query query = getSession().createSQLQuery("delete from Student where stuno = :stuno");
		query.setString("stuno", stuno);
		query.executeUpdate();
		
	}

	@SuppressWarnings("unchecked")
	public List<Student> findAllStudents() {
		Criteria criteria = createEntityCriteria();
		return (List<Student>) criteria.list();
	}

	public Student findStudentByStuno(String stuno) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("stuno", stuno));
		return (Student) criteria.uniqueResult();
	}
	
	public Session sess(){
		return getSession();
	}
}
