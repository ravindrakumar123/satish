package com.visog.springmvc.service;

import java.util.List;

import com.visog.springmvc.model.Student;

public interface EmployeeService {

	Student findById(int id);
	
	void saveStudent(Student student);
	
	void updateStudent(Student student);
	
	void deleteStudentByStuno(String stuno);

	List<Student> findAllStudents(); 
	
	Student findStudentByStuno(String stuno);

	boolean isStudentStunoUnique(Integer id, String stuno);

}
