package com.example.Student_New1.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "roles")
public class Role {
    @Id
    private String id;
    private ERole name;

    public Role() {
    }

    public Role(ERole name) {
        this.name = name;
    }

    // Getters and Setters
}
