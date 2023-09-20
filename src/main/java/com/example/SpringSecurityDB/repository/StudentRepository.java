package com.example.SpringSecurityDB.repository;

import com.example.SpringSecurityDB.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    public Student findByUsername(String username);
}
