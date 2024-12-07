package com.example.Student_New1.Service;

import java.util.List;

import com.example.Student_New1.Model.Student;

public interface StudentService {
    Student saveStudent(Student student);

    List<Student> getAllStudents();

    Student getStudentById(String id);

    Student updateStudent(Student student, String id);

    void deleteStudent(String id);

    List<Student> getStudentsByYearOfEnrollment(Integer yearOfEnrollment);
    String getDepartmentById(String id);
    void removeStudentsByYearOfEnrollment(Integer yearOfEnrollment);
}
