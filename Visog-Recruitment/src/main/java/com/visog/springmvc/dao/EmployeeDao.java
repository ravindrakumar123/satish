package com.visog.springmvc.dao;

import java.util.List;

import com.visog.springmvc.model.Student;

public interface EmployeeDao {

	Student findById(int id);

	void saveStudent(Student student);
	
	void deleteStudentByStuno(String stuno);
	
	List<Student> findAllStudents();

	Student findStudentByStuno(String stuno);

}
