package com.example.nikita.service;

import com.example.nikita.dto.*;
import com.example.nikita.entity.*;
import com.example.nikita.exception_handling.NoSuchEmployeeException;
import com.example.nikita.mapper.EmployeeMapper;
import com.example.nikita.payload.request.ChangePasswordRequest;
import com.example.nikita.payload.request.ChangeQualityRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.nikita.repository.EmployeeRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Value("${mail.username}")
    private String emailFrom;

    @Value("${host.name}")
    private String hostName;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private  MailSender mailSender;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override

    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeDTO> employeeDTOS = new ArrayList<>();
        for (Employee employee:employees){

            EmployeeDTO employeeDTO = employeeMapper.toEmployeeDTO(employee);
            employeeDTOS.add(employeeDTO);

        }
        return employeeDTOS;
    }

    @Override
    @Transactional
    public Employee saveEmployee(EmployeeDTO employeedto) {
        Employee employee = employeeMapper.toEmployee(employeedto);
        return employeeRepository.save(employee);
    }

    @Override

    public EmployeeDTO getEmployee(int id) {
        Optional<Employee> optionalEmployee1 = employeeRepository.findById(id);

        Employee employee = optionalEmployee1.orElse(null);

        if (employee== null) {
            throw new NoSuchEmployeeException("There is no employee with id = " + id + " in database");
        }

        EmployeeDTO employeeDTO = employeeMapper.toEmployeeDTO(employee);

        if (employeeDTO == null) {
            throw new NoSuchEmployeeException("There is no employee with id = " + id + " in database");
        }

        Optional<EmployeeDTO> optionalEmployee = Optional.ofNullable(employeeDTO);
        return optionalEmployee.orElse(null);
    }

    @Override

    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }


    @Override
    @Transactional
    public Employee updateEmployee(ChangeQualityRequest employeedto) {
        EmployeeDTO employee = getEmployee(employeedto.getId());
        employee.setName(employeedto.getName());
        employee.setSurname(employeedto.getSurname());
        employee.setSalary(employeedto.getSalary());
        employee.setDepartment(employeedto.getDepartment());
        employee.setCar(employeedto.getCar());
        employee.setHouse(employeedto.getHouse());
        employee.setPets(employeedto.getPets());
        employee.setProjects(employeedto.getProjects());
        Employee employeeRes = employeeMapper.toEmployee(employee);
        return employeeRepository.save(employeeRes);
    }

    @Override
    public void sendEmailMessage(String userEmail, String name) {
        String messageText = String.format("Здраствуйте, %s!" +
                        " Мы хотим сообщить вам что ваш пароль " +
                        " был изменен ", name);
        SimpleMailMessage messageToActivateUser = new SimpleMailMessage();
        messageToActivateUser.setTo(userEmail);
        messageToActivateUser.setFrom(emailFrom);
        messageToActivateUser.setSubject("Ваш пароль был изменен");
        messageToActivateUser.setText(messageText);

        mailSender.send(messageToActivateUser);
    }


    @Override
    public Employee saveWithNewPassword(ChangePasswordRequest changePasswordRequest){
        EmployeeDTO employee = getEmployee(changePasswordRequest.getId());
        employee.setPassword(passwordEncoder.encode(changePasswordRequest.getPassword()));
        Employee employeeRes = employeeMapper.toEmployee(employee);
        return employeeRepository.save(employeeRes);
    }
    public boolean existsByUsername(String username){
        return employeeRepository.existsByUsername(username);
    }



    public boolean existsByPassword(String password){
        return employeeRepository.existsByPassword(password);
    };
}
