package com.example.nikita.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.nikita.dao.EmployeeDAO;
import com.example.nikita.entity.Employee;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDAO employeeDAO;

    @Override

    public List<Employee> getAllEmployees() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeDAO.save(employee);
    }

    @Override

    public Employee getEmployee(int id) {
        Optional<Employee> optionalEmployee = employeeDAO.findById(id);
        return optionalEmployee.orElse(null);
    }

    @Override

    public void deleteEmployee(int id) {
        employeeDAO.deleteById(id);
    }


}
