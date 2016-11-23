package com.visog.springmvc.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="STUDENT")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Size(min=3, max=50)
	@Column(name = "NAME", nullable = false)
	private String name;

	@Size(min=3, max=50)
	@Column(name = "GENDER", nullable = false)
	private String gender;
	
	//@Column(name = "ADDRESS", nullable = false)
	//private String address;
	
	@Column(name = "QUALIFICATION", nullable = false)
	private String qualification;
	
	@Column(name = "YEAR", nullable = false)
	private int year;
	
	@Column(name = "MARKS", nullable = false)
	private int marks;
	
	@Column(name = "FNAME", nullable = false)
	private String fatherName;

	@NotNull
	@DateTimeFormat(pattern="dd/MM/yyyy") 
	@Column(name = "DOB", nullable = false)
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private LocalDate dateOfBirth;
	
	@Column(name="ADDRESS", nullable=false)
	private String address;
	
	@NotEmpty
	@Column(name = "STUNO", unique=true, nullable = false)
	private String stuno;
	
	/*@Column(name="FILE_NAME", nullable=false)
	private String fileName;
	
	@Column(name="FILE_DATA", nullable=false)
	private byte[] data;
*/
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getStuno() {
		return stuno;
	}

	public void setStuno(String stuno) {
		this.stuno = stuno;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	

	/*public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}*/

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((stuno == null) ? 0 : stuno.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Student))
			return false;
		Student other = (Student) obj;
		if (id != other.id)
			return false;
		if (stuno == null) {
			if (other.stuno != null)
				return false;
		} else if (!stuno.equals(other.stuno))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", date of birth="
				+ dateOfBirth + ", ssn=" + stuno + "]";
	}
	
	
	

}
