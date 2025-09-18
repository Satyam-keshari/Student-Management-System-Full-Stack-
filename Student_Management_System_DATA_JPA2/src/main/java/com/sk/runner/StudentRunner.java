package com.sk.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sk.entity.Student;
import com.sk.service.StudentService;

//@Component
public class StudentRunner implements CommandLineRunner {

	@Autowired
	private StudentService service;
	
	@Override
	public void run(String... args) throws Exception
	{
		
		//insert data
		service.addStudent(new Student(null,"Smith", "CSE", "Smith@gmail.com", 2022));
		service.addStudent(new Student(null,"Peter", "IT", "Peter@gmail.com", 2023));
		service.addStudent(new Student(null,"Kevin", "CSE", "Kevin@gmail.com", 2022));
		service.addStudent(new Student(null,"Sanorita", "MBA", "Sanorita@gmail.com", 2024));
		service.addStudent(new Student(null,"Margerita", "MBA", "Margerita@gmail.com", 2023));
		
		//fetch data
		service.getAllStudents().forEach(System.out::println);
	
		//fetch data by name
		service.getStudentByName("Kevin").forEach(System.out::println);
		
		//fecth data by dept
		service.getStudentByDept("MBA").forEach(System.out::println);
		
		//delete data by id
		service.deleteStudent(4);

		
	}

}
