package com.java.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		System.out.println("Welcome to Student Management App");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("PRESS 1 TO ADD STUDENT");
			System.out.println("PRESS 2 TO DELETE STUDENT");
			System.out.println("PRESS 3 TO DISPLAY STUDENT");
			System.out.println("PRESS 4 TO UPDATE STUDENT");
			System.out.println("PRESS 5 TO EXIT APP");
			int c = Integer.parseInt(br.readLine());
			if(c==1) {
				//Add Students
				System.out.println("Enter User Name");
				String name = br.readLine();
				
				System.out.println("Enter User Phone");
				String phone = br.readLine();
				
				System.out.println("Enter User City");
				String city = br.readLine();
				
				//Create student object to store student
				Student st = new Student(name,phone,city);
				boolean answer = StudentDao.insertStudentToDB(st);
				if(answer) {
					System.out.println("Student added Successfully....");
				}else {
					System.out.println("Something went wrong...");
				}
				System.out.println(st);
				
			}else if(c==2) {
				//Delete Students
				System.out.println("Enter Student ID To Delete: ");
				int userId = Integer.parseInt(br.readLine());
				boolean f = StudentDao.deleteStudent(userId);
				if(f) {
					System.out.println("Deleted......");
				}else {
					System.out.println("Something went wrong.....");
				}
				
			}else if(c==3) {
				//Display Students
				StudentDao.showAllStudent();
				
			}else if(c==4) {
				//Display Update
				System.out.println("Enter ID Which You Want To Update");
				int id = Integer.parseInt(br.readLine());
				
				System.out.println("Enter New User Name");
				String name = br.readLine();
				
				System.out.println("Enter New User Phone");
				String phone = br.readLine();
				
				System.out.println("Enter New User City");
				String city = br.readLine();
				
				//Update student object to store student
				Student st = new Student(id,name,phone,city);
				boolean answer = StudentDao.updateStudentToDB(st);
				if(answer) {
					System.out.println("Student updated Successfully....");
				}else {
					System.out.println("Something went wrong...");
				}
				System.out.println(st);
				
			}else if(c==5) {
				//Exit App
				break;
			}else {
				System.out.println("You Have Entered which is not assigned or Illegal Input");
			}
		}
		System.out.println("Thank You for using application....");
		System.out.println("See you soon...bye bye");
	}

}
