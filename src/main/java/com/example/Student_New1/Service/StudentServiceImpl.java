package com.example.Student_New1.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Student_New1.Model.Student;
import com.example.Student_New1.Repository.StudentRepository;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(String id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    @Override
    public Student updateStudent(Student student, String id) {
        Student existingStudent = getStudentById(id);
        existingStudent.setFirstName(student.getFirstName()); // Corrected method call
        existingStudent.setLastName(student.getLastName()); // Corrected method call
        existingStudent.setEmail(student.getEmail()); // Corrected method call
        existingStudent.setDepartment(student.getDepartment());
        existingStudent.setYearOfEnrollment(student.getYearOfEnrollment());
        return studentRepository.save(existingStudent);
    }

    @Override
    public void deleteStudent(String id) {
        studentRepository.deleteById(id);
    }

     @Override
    public List<Student> getStudentsByYearOfEnrollment(Integer yearOfEnrollment) {
        return studentRepository.findByYearOfEnrollment(yearOfEnrollment);
    }

    @Override
    public String getDepartmentById(String id) {
        return studentRepository.findDepartmentById(id);
    }

    @Transactional
    @Override
    public void removeStudentsByYearOfEnrollment(Integer yearOfEnrollment) {
        studentRepository.deleteByYearOfEnrollment(yearOfEnrollment);
    }
}
