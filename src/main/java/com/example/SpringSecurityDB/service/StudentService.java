package com.example.SpringSecurityDB.service;

import com.example.SpringSecurityDB.model.Student;
import com.example.SpringSecurityDB.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRep;
    @Autowired
    private PasswordEncoder encoder;

    public List<Student> displayAll(){
        return   studentRep.findAll();

    }

    public Student register(Student student) {
        student.setPassword(encoder.encode(student.getPassword()));
        return studentRep.save(student);
    }

    public Student getDetails(String username) {
        return studentRep.findByUsername(username);
    }

    public String getStudentRoles(String username) {
        return studentRep.findByUsername(username).getRoles();
    }
}
