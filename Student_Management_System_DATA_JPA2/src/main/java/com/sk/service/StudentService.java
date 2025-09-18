package com.sk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sk.entity.Student;
import com.sk.repository.IStudentRepository;

@Service
public class StudentService 
{
	@Autowired
	private IStudentRepository repo;

	public Student addStudent(Student student)
	{
		return repo.save(student);
	}
	public List<Student> getAllStudents()
	{
		return repo.findAll();
	}
	public List<Student> getStudentByDept(String dept)
	{
		return repo.findByDepartment(dept);
	}
	public List<Student> getStudentByName(String name)
	{
		return repo.findByName(name);
	}
	public void deleteStudent(int id)
	{
		repo.deleteById(id);
	}
	public boolean existsById(Integer id) {
	    return repo.existsById(id);
	}

}
