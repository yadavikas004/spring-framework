package com.springcore.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages = "com.springcore.javaconfig")  // If this line removed also still it will work
public class JavaConfig {

	@Bean
	public Samosa getSamosa() {
		return new Samosa();
	}

	@Bean(name = {"student","temp","con"})
	public Student getStudent() {
		//creating a new student object
		Student student = new Student(getSamosa());
		return student;
	}
}
