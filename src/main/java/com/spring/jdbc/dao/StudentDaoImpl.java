package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.entity.Student;

@ComponentScan("studentDao")
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int insert(Student student) {
		// insert query
		// insert query
		String query = "insert into student(id,name,city) values(?,?,?)";
		int r = this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());
		return r;
	}

	@Override
	public int change(Student student) {
		// updating data
		String query = "update student set name=?, city=? where id=?";
		int r = this.jdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());
		return r;
	}

	@Override
	public int delete(int studentId) {
		// delete operation
		String query = "delete from student where id=?";
		int r = this.jdbcTemplate.update(query, studentId);
		return r;
	}

	@Override
	public Student getStudent(int studentId) {
		// select single student data
		String query = "select * from student where id=?;";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		Student student = this.jdbcTemplate.queryForObject(query, rowMapper, studentId);
		return student;
	}

	@Override
	public List<Student> getAllStudents() {
		// selecting multiple students
		String query = "select * from student;";
		List<Student> student = this.jdbcTemplate.query(query, new RowMapperImpl());
		return student;
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
