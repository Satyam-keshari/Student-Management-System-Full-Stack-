package com.sk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sk.entity.Student;

public interface IStudentRepository extends JpaRepository<Student, Integer> 
{
	List<Student> findByDepartment(String department);
	List<Student> findByName(String name );
	List<Student> findByAdmissionYearGreaterThanEqual(int year);

}
