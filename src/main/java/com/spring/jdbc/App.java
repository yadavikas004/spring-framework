package com.spring.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.io.*;
import java.util.List;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entity.Student;

public class App {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		System.out.println("My Program Started...");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/jdbcconfig.xml");
		ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
//		JdbcTemplate template = context.getBean("jdbcTemplate",JdbcTemplate.class);

		// insert query
//		String query = "insert into student(id,name,city) values(?,?,?)";

//		int result = template.update(query,245,"Manish Kumar","Kanpur");
//		System.out.println("number of record inserted..."+result);

		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

		while (true) {

			System.out.println("ENTER 1 FOR INSERT RECORD");
			System.out.println("ENTER 2 FOR UPDATE RECORD");
			System.out.println("ENTER 3 FOR DELETE RECORD");
			System.out.println("ENTER 4 FOR SELECT RECORD BY ID");
			System.out.println("ENTER 5 FOR SELECT RECORD");
			System.out.println("ENTER 6 TO EXIT THE APP");
			System.out.println("========================================");
			int select = Integer.parseInt(br.readLine());
			System.out.println("========================================");

			if (select == 1) {
				// Insert
				Student student = new Student();
				System.out.println("INSERT ID");
				int studentId = Integer.parseInt(br.readLine());
				student.setId(studentId);

				System.out.println("INSERT NAME");
				String studentName = br.readLine();
				student.setName(studentName);

				System.out.println("INSERT CITY");
				String studentCity = br.readLine();
				student.setCity(studentCity);

				int result = studentDao.insert(student);
				System.out.println("========================================");
				System.out.println("STUDENT ADDED " + result);
				System.out.println("========================================");
			} else if (select == 2) {
				// UPDATE
				Student student = new Student();

				System.out.println("INSERT ID");
				int studentId = Integer.parseInt(br.readLine());
				student.setId(studentId);

				System.out.println("INSERT NAME");
				String studentName = br.readLine();
				student.setName(studentName);

				System.out.println("INSERT CITY");
				String studentCity = br.readLine();
				student.setCity(studentCity);

				int result = studentDao.change(student);
				System.out.println("========================================");
				System.out.println("STUDENT DATA UPDATED " + result);
				System.out.println("========================================");
			} else if (select == 3) {
				// DELETE
				try {
					System.out.println("ENTER ID TO DELETE");
					int delete = Integer.parseInt(br.readLine());
					int result = studentDao.delete(delete);
					System.out.println("========================================");
					System.out.println("STUDENT DATA DELETED " + result);
					System.out.println("========================================");
				} catch (NumberFormatException | IOException e) {
					e.printStackTrace();
					System.out.println("========================================");
				}
			} else if (select == 4) {
				// SELECT
				System.out.println("ENTER ID TO FETCH RECORD");
				int fetch = Integer.parseInt(br.readLine());
				Student result = studentDao.getStudent(fetch);
				System.out.println("========================================");
				System.out.println("STUDENT DATA FETCHED");
				System.out.println(result);
				System.out.println("========================================");
			} else if (select == 5) {
				// SELECT
				System.out.println("ALL DATA HAD BEEN FETCHED");
				System.out.println("========================================");
				List<Student> students = studentDao.getAllStudents();
				System.out.println("STUDENT DATA FETCHED : ");
				for(Student s: students) {
					System.out.println(s);
				}
				System.out.println("========================================");
				
			} else if (select == 6) {
				System.out.println("Application Terminated Here");
				System.out.println("========================================");
				System.exit(0);
			} else {
				// Wrong Input
				System.out.println("You have entered the wrong input");
				System.out.println("========================================");
			}
		}

	}

}
