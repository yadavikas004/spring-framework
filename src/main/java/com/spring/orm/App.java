package com.spring.orm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entity.Student;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/orm/ormconfig.xml");
		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean go = true;
		try {
			/*
			 * System.out.println("ENTER STUDENT ID"); int sid =
			 * Integer.parseInt(br.readLine()); System.out.println("Enter STUDENT NAME");
			 * String name = br.readLine(); System.out.println("ENTER STUDENT CITY"); String
			 * city = br.readLine(); Student student = new Student(sid,name,city); int r =
			 * studentDao.insert(student); System.out.println("done "+r);
			 */

			while (go) {

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
					student.setStudentId(studentId);

					System.out.println("INSERT NAME");
					String studentName = br.readLine();
					student.setStudentName(studentName);

					System.out.println("INSERT CITY");
					String studentCity = br.readLine();
					student.setStudentCity(studentCity);

					int result = studentDao.insert(student);
					System.out.println("========================================");
					System.out.println("STUDENT ADDED " + result);
					System.out.println("========================================");
				} else if (select == 2) {
					// UPDATE
					Student student = new Student();

					System.out.println("INSERT ID");
					int studentId = Integer.parseInt(br.readLine());
					student.setStudentId(studentId);

					System.out.println("INSERT NAME");
					String studentName = br.readLine();
					student.setStudentName(studentName);

					System.out.println("INSERT CITY");
					String studentCity = br.readLine();
					student.setStudentCity(studentCity);

					int result = studentDao.insert(student);
					System.out.println("========================================");
					System.out.println("STUDENT DATA UPDATED " + result);
					System.out.println("========================================");
				} else if (select == 3) {
					// DELETE
					try {
						System.out.println("ENTER ID TO DELETE");
						int delete = Integer.parseInt(br.readLine());
						studentDao.deleteStudent(delete);
						System.out.println("========================================");
						System.out.println("STUDENT DATA DELETED ");
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
					List<Student> students = studentDao.getAllStudent();
					System.out.println("STUDENT DATA FETCHED : ");
					for (Student s : students) {
						System.out.println(s.getStudentId()+" "+s.getStudentName()+" "+s.getStudentCity());
					}
					System.out.println("========================================");

				} else if (select == 6) {
					System.out.println("Application Terminated Here");
					System.out.println("========================================");
					go = false;
					break;
				} else {
					// Wrong Input
					System.out.println("You have entered the wrong input");
					System.out.println("========================================");
				}
			}
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
