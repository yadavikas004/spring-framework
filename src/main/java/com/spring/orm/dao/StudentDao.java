package com.spring.orm.dao;

import java.util.List;

import com.spring.orm.entity.Student;

public interface StudentDao {
	
	public int insert (Student student);
	
	public Student getStudent(int studentId);
	
	public List<Student> getAllStudent();
	
	public void deleteStudent(int studentId);
	
	public void updateStudent(Student student);
}
