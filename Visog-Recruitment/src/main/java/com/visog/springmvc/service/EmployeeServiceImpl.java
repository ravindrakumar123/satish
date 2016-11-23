package com.visog.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.visog.springmvc.dao.EmployeeDao;
import com.visog.springmvc.model.Student;

@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao dao;
	
	public Student findById(int id) {
		return dao.findById(id);
	}

	public void saveStudent(Student student) {
		dao.saveStudent(student);
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db once transaction ends. 
	 */
	public void updateStudent(Student student) {
		Student entity = dao.findById(student.getId());
		if(entity!=null){
			entity.setName(student.getName());
			entity.setDateOfBirth(student.getDateOfBirth());
			entity.setStuno(student.getStuno());
			entity.setFatherName(student.getFatherName());
			entity.setGender(student.getGender());
			entity.setQualification(student.getQualification());
			entity.setYear(student.getYear());
			entity.setMarks(student.getMarks());
			entity.setAddress(student.getAddress());
		}
	}

	public void deleteStudentByStuno(String stuno) {
		dao.deleteStudentByStuno(stuno);
	}
	
	public List<Student> findAllStudents() {
		return dao.findAllStudents();
	}

	public Student findStudentByStuno(String stuno) {
		return dao.findStudentByStuno(stuno);
	}

	public boolean isStudentStunoUnique(Integer id, String stuno) {
		Student student = findStudentByStuno(stuno);
		return ( student == null || ((id != null) && (student.getId() == id)));
	}


		
}
