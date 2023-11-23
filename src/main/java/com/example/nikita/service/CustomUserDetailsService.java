package com.example.nikita.service;


import com.example.nikita.dao.EmployeeDAO;
import com.example.nikita.entity.ERole;
import com.example.nikita.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final EmployeeDAO employeeDAO;

    @Autowired
    public CustomUserDetailsService(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        Employee user = employeeDAO.findEmployeeByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found with username: " + username));
        return build(user);
    }

    public Employee loadUserById(int id) {
        return employeeDAO.findById(id).orElse(null);
    }

    public static Employee build(Employee user) {
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().name()))
                .collect(Collectors.toList());

        return new Employee(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                authorities);
    }
}

