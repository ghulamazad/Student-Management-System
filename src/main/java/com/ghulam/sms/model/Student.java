package com.ghulam.sms.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id", length = 10)
	private int id;

	@Column(name = "name", length = 100)
	@NotNull(message = "Name is mandatory")
	@Size(max = 100, message = "must be less than or equal to 100 characters")
	private String name;

	@Column(name = "age", length = 2)
	@NotNull
	@Min(18)
	@Max(99)
	private Integer age;
	private Date dob;

	@Column(name = "mobile", length = 10)
	@NotNull(message = "Mobile number is mandatory")
	@Size(min = 10, max = 10, message = "Not valid mobile number")
	private String mobile;

	@Column(name = "email", length = 100)
	@Email
	@Size(max = 100, message = "must be less than or equal to 100 characters")
	private String email;

	@Column(name = "student_address", length = 500)
	@NotNull(message = "Address is mandatory")
	@Size(max = 500, message = "must be less than or equal to 500 characters")
	private String address;

	@Column(name = "course_id", length = 10)
	private int courseId;

	@Column(name = "active")
	private boolean active;

	public Student() {
	}

	public Student(String name, Integer age, Date dob, String mobile, String email, String address, int courseId, boolean active) {
		this.name = name;
		this.age = age;
		this.dob = dob;
		this.mobile = mobile;
		this.email = email;
		this.address = address;
		this.courseId = courseId;
		this.active = active;
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
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

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
