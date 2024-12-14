package com.msahoo.springbootaws.service;

import com.msahoo.springbootaws.model.Employee;
import com.msahoo.springbootaws.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public List<Employee> findAllEmployees() {
        List<Employee> employees = repository.findAll();
        if(employees.isEmpty()) {
            return Collections.emptyList();
        }
        return employees;
    }

    public List<Employee> findEmployeesByName(String name) {
        List<Employee> employees = repository.findByName(name);
        if(employees.isEmpty()) {
            return Collections.emptyList();
        }
        return employees;
    }

    public Employee findEmployeeById(int id) {
        Optional<Employee> employee = repository.findById(id);
        return employee.orElse(null);
    }

    public Employee createEmployee(Employee employee) {
        return repository.insert(employee);
    }

    public void deleteEmployeeById(int id) {
        repository.deleteById(id);;
    }

    public List<Employee> findByDepartmentName(String departmentName) {
        List<Employee> employees = repository.findByDepartmentName(departmentName);
        if(employees.isEmpty()) {
            return Collections.emptyList();
        }
        return employees;
    }

}
