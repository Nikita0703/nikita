package com.example.nikita.controller;

import com.example.nikita.mapper.*;
import com.example.nikita.repository.RoleRepository;
import com.example.nikita.dto.EmployeeDTO;
import com.example.nikita.entity.ERole;
import com.example.nikita.entity.Employee;
import com.example.nikita.entity.Role;
import com.example.nikita.payload.request.LoginRequest;
import com.example.nikita.payload.request.SignupRequest;
import com.example.nikita.payload.response.JwtResponse;
import com.example.nikita.payload.response.MessageResponse;
import com.example.nikita.security.JwtUtils;

import com.example.nikita.service.EmployeeService;
import com.example.nikita.validations.ResponseErrorValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

//@CrossOrigin(origins = "http://localhost:3000", methods = { RequestMethod.GET, RequestMethod.POST }, allowedHeaders = { "Content-Type", "Authorization" })
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    EmployeeService userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    JwtResponseMapper mapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    ResponseErrorValidation responseErrorValidation;

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

        return ResponseEntity.ok(mapper.toJwtResponse(jwt,userDetails,roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest, BindingResult result) {
        ResponseEntity<Object> errors = responseErrorValidation.mapValidationService(result);
        if (errors != null) {
            return errors;
        } else {

            if (userRepository.existsByUsername(signUpRequest.getUsername())) {
                return ResponseEntity
                        .badRequest()
                        .body(new MessageResponse("Error: Username is already taken!"));
            }

            if (userRepository.existsByPassword(signUpRequest.getPassword())) {
                return ResponseEntity
                        .badRequest()
                        .body(new MessageResponse("Error: password is already in use!"));
            }

            EmployeeDTO user = new EmployeeDTO(signUpRequest.getUsername(),
                    encoder.encode(signUpRequest.getPassword()),
                    signUpRequest.getEmail(),
                    signUpRequest.getName(),
                    signUpRequest.getSurname(),
                    signUpRequest.getSalary(),
                    signUpRequest.getDepartment(),
                    signUpRequest.getCar(),
                    signUpRequest.getHouse(),
                    signUpRequest.getPets(),
                    signUpRequest.getProjects()
            );


            String strRole = String.valueOf(ERole.ROLE_USER);
            Set<Role> roles = new HashSet<>();

            if (strRole == null) {
                Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                        .orElseThrow(() -> new RuntimeException("Error: Role is not found 1."));
                roles.add(userRole);
            } else {
                switch (strRole) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found 2."));
                        roles.add(adminRole);

                        break;

                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found 3."));
                        roles.add(userRole);
                }

            }


            user.setRoles(roles);
            userRepository.saveEmployee(user);

            return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
        }
    }
}

