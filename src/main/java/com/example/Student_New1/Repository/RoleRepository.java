package com.example.Student_New1.Repository;

import com.example.Student_New1.Model.ERole;
import com.example.Student_New1.Model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(ERole name);
}
