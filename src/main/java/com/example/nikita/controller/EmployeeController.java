package com.example.nikita.controller;

import com.example.nikita.dto.EmployeeDTO;
import com.example.nikita.dto.View;
import com.example.nikita.payload.request.ChangePasswordRequest;
import com.example.nikita.payload.request.ChangeQualityRequest;
import com.example.nikita.service.EmployeeService;
import com.example.nikita.validations.ResponseErrorValidation;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api1")
//@CrossOrigin(origins = "http://localhost:3000", methods = { RequestMethod.GET, RequestMethod.POST,RequestMethod.OPTIONS }, allowedHeaders = { "Content-Type", "Authorization" })
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ResponseErrorValidation responseErrorValidation;

    @GetMapping("/employees")
    @JsonView(View.Employee.class)
    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeDTO> employees = employeeService.getAllEmployees();
        return employees;
    }

    @GetMapping("/employees/{id}")
    @JsonView(View.Employee.class)
    public EmployeeDTO getEmployee(@PathVariable int id) {
        EmployeeDTO employee = employeeService.getEmployee(id);
        return employee;
    }

    @PostMapping("/employees")
    public EmployeeDTO saveEmployee(@RequestBody EmployeeDTO employeedto) {
        employeeService.saveEmployee(employeedto);
        return employeedto;
    }

    @PatchMapping("/employees")
    public ChangeQualityRequest updateEmployee(@RequestBody ChangeQualityRequest employeeDTO) {
        employeeService.updateEmployee(employeeDTO);
        return employeeDTO;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        EmployeeDTO employee = employeeService.getEmployee(id);
        employeeService.deleteEmployee(id);
        return "Employee with id = " + id + " was deleted";
    }

    @PatchMapping("/changePassword")
    public ResponseEntity<?> changeEmail(@RequestBody @Valid ChangePasswordRequest changePasswordRequest, BindingResult result){
        ResponseEntity<Object> errors = responseErrorValidation.mapValidationService(result);
        if (errors != null) {
            return errors;
        } else {
            EmployeeDTO employee = employeeService.getEmployee(changePasswordRequest.getId());
            employeeService.sendEmailMessage(employee.getEmail(), employee.getName());
            employeeService.saveWithNewPassword(changePasswordRequest);
            return ResponseEntity.ok("Change password successfully");
        }
    }
}
