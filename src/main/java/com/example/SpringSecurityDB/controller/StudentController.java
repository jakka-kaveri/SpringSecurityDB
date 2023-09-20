package com.example.SpringSecurityDB.controller;

import com.example.SpringSecurityDB.model.Student;
import com.example.SpringSecurityDB.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentSer ;

    private PasswordEncoder encoder;



//    public StudentController(StudentService service, PasswordEncoder encoder) {
//        this.studentSer= service;
//        this.encoder = encoder;
//    }

    @GetMapping()
    public List<Student> getAllStudentsData() {      //localhost:8080/
        return studentSer.displayAll();

    }


    @PostMapping("/register")
    public Student registerStudent(@RequestBody Student student) {
        return studentSer.register(student);
    }

    @GetMapping("/studentInfo")
    public Student getStudentInfo(@RequestParam("username") String username) {

        return studentSer.getDetails(username);
    }

    @GetMapping("/getStudentRoles")
    public String getStudentRoles(@RequestParam("username") String username) {
        return studentSer.getStudentRoles(username);
    }
}
