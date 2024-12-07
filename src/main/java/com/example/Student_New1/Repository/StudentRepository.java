package com.example.Student_New1.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.Student_New1.Model.Student;

import java.util.List;

public interface StudentRepository extends MongoRepository<Student, String> {

     // Find students by year of enrollment
     List<Student> findByYearOfEnrollment(int year);

     // Custom query to find the department by student ID
     @Query(value = "{ '_id': ?0 }", fields = "{ 'department': 1 }")
     String findDepartmentById(String id);
 
     // Delete students by year of enrollment
     void deleteByYearOfEnrollment(Integer yearOfEnrollment);
}
