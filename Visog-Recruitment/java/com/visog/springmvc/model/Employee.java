package com.visog.springmvc.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="members")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Size(min=3, max=50)
	@Column(name = "NAME", nullable = false)
	private String name;

	@NotNull
	@DateTimeFormat(pattern="dd/MM/yyyy") 
	@Column(name = "date_of_birth", nullable = false)
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private LocalDate dateOfBirth;

	@NotNull
	@Column(name = "fname", nullable = false)
	private String fname;
	
	@Column(name = "gender", nullable = false)
	private String gender;
	
	@NotEmpty
	@Column(name = "Password", unique=true, nullable = false)
	private String password;

	@Column(name = "mobile", nullable = false)
	private String mobile;
	
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "address", nullable = false)
	private String address;
	
	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Employee))
			return false;
		Employee other = (Employee) obj;
		if (id != other.id)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", dateOfBirth="
				+ dateOfBirth + ", gender=" + gender + ", password=" + password + "]";
	}
	
	
	

}
