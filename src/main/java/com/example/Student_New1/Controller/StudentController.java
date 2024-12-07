package com.example.Student_New1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Student_New1.Model.Student;
import com.example.Student_New1.Service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable String id) {
        return new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable String id, @RequestBody Student student) {
        return new ResponseEntity<>(studentService.updateStudent(student, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable String id) {
        studentService.deleteStudent(id);
        return new ResponseEntity<>("Student deleted successfully", HttpStatus.OK);
    }

    // Custom endpoint to get students by year of enrollment
    @GetMapping("/year/{year}")
    public List<Student> getStudentsByYearOfEnrollment(@PathVariable Integer year) {
        return studentService.getStudentsByYearOfEnrollment(year);
    }

    // Custom endpoint to get the department by student ID
    @GetMapping("/{id}/department")
    public String getDepartmentById(@PathVariable String id) {
        return studentService.getDepartmentById(id);
    }

    // Custom endpoint to remove students by year of enrollment
    @DeleteMapping("/year/{year}")
    public void removeStudentsByYearOfEnrollment(@PathVariable Integer year) {
        studentService.removeStudentsByYearOfEnrollment(year);
    }
}
