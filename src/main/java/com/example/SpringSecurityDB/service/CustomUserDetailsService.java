package com.example.SpringSecurityDB.service;

import com.example.SpringSecurityDB.model.Student;
import com.example.SpringSecurityDB.repository.StudentRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final StudentRepository studentRepository;

    public CustomUserDetailsService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student student = studentRepository.findByUsername(username);
        if (student == null) {
            throw new UsernameNotFoundException("student not found with username: " + username);
        }
//        String[] rolesArray = student.getRoles().split(",");
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        for (String role : rolesArray) {
//            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.trim())); // Add "ROLE_" prefix
//        }
//
//        return new User(student.getUsername(), student.getPassword(), authorities);

        return new User(student.getUsername(), student.getPassword(), new ArrayList<>());

    }
    }




