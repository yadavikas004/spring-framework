package com.springcore.stereotype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext con = new ClassPathXmlApplicationContext("com/springcore/stereotype/stereoconfig.xml");
		Student student = con.getBean("ob",Student.class); //Here student represent name has not be used ob name used which was defined in tag
		/*
		 * System.out.println(student); System.out.println(student.getAddress());
		 * System.out.println(student.getAddress().getClass().getName());
		 */
		
		Student student1 = con.getBean("ob",Student.class);
//		System.out.println(student1.hashCode());
		
		Student student2 = con.getBean("ob",Student.class);
//		System.out.println(student2.hashCode());
		
		Teacher t1 = con.getBean("teacher",Teacher.class);
		Teacher t2 = con.getBean("teacher",Teacher.class);
		System.out.println(t1.hashCode());
		System.out.println(t2.hashCode());
	}

}
