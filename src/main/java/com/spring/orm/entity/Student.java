package com.spring.orm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="STUDENT_ORM")
public class Student {
	
	@Id
	@Column(name = "STUDENT_ID")  //@GeneratedValue(strategy = GenerationType.IDENTITY)  --> To Make Id in Sequence
	private int studentId;
	
	@Column(name = "STUDENT_NAME")
	private String StudentName;
	
	@Column(name = "STUDENT_CITY")
	private String studentCity;

	public Student(int studentId, String studentName, String studentCity) {
		super();
		this.studentId = studentId;
		StudentName = studentName;
		this.studentCity = studentCity;
	}

	public Student() {
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return StudentName;
	}

	public void setStudentName(String studentName) {
		StudentName = studentName;
	}

	public String getStudentCity() {
		return studentCity;
	}

	public void setStudentCity(String studentCity) {
		this.studentCity = studentCity;
	}
	
	
	
	
}
