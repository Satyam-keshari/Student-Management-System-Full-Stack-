package com.sk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sk.entity.Student;
import com.sk.repository.IStudentRepository;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "http://localhost:5500") // allow your frontend (adjust port if needed)
public class StudentController {

    @Autowired
    private IStudentRepository studentRepo;

    // Get all students
    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    // Add a new student
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentRepo.save(student);
    }

    // Delete student by id
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Integer id) {
        studentRepo.deleteById(id);
    }
    @GetMapping("/department/{dept}")
    public List<Student> getStudentsByDepartment(@PathVariable String dept) {
        return studentRepo.findByDepartment(dept);
    }
    
    @GetMapping("/name/{name}")
    public List<Student> getStudentsByName(@PathVariable String name) {
        return studentRepo.findByName(name);
    }
}
