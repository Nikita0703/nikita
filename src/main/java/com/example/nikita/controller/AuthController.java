package com.example.nikita.controller;

import com.example.nikita.dao.EmployeeDAO;
import com.example.nikita.dao.RoleDAO;
import com.example.nikita.dto.EmployeeDTO;
import com.example.nikita.entity.ERole;
import com.example.nikita.entity.Employee;
import com.example.nikita.entity.Role;
import com.example.nikita.mapper.CarMapper;
import com.example.nikita.mapper.HouseMapper;
import com.example.nikita.mapper.PetMapper;
import com.example.nikita.mapper.ProjectMapper;
import com.example.nikita.payload.request.LoginRequest;
import com.example.nikita.payload.request.SignupRequest;
import com.example.nikita.payload.response.JwtResponse;
import com.example.nikita.payload.response.MessageResponse;
import com.example.nikita.security.JwtUtils;

import com.example.nikita.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    EmployeeService userRepository;

    @Autowired
    RoleDAO roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    CarMapper carMapper;

    @Autowired
    HouseMapper houseMapper;

    @Autowired
    PetMapper petMapper;

    @Autowired
    ProjectMapper projectMapper;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);



        Employee userDetails = (Employee) authentication.getPrincipal();

        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getName(),
                userDetails.getSurname(),
                userDetails.getSalary(),
                userDetails.getDepartment(),
                carMapper.toCarDTO(userDetails.getCar()),
                houseMapper.toHouseDTO(userDetails.getHouse()),
                petMapper.toPetDTOList(userDetails.getPets()),
                projectMapper.toProjectDTOList(userDetails.getProjects()),
                roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByPassword(signUpRequest.getPassword())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        EmployeeDTO user = new EmployeeDTO(signUpRequest.getUsername(),
                encoder.encode(signUpRequest.getPassword()),
                signUpRequest.getName(),
                signUpRequest.getSurname(),
                signUpRequest.getSalary(),
                signUpRequest.getDepartment(),
                signUpRequest.getCar(),
                signUpRequest.getHouse(),
                signUpRequest.getPets(),
                signUpRequest.getProjects()
                );

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;

                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }

        user.setRoles(roles);
        userRepository.saveEmployee(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}

