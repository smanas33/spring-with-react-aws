package com.msahoo.springbootaws.service;

import com.msahoo.springbootaws.model.Department;
import com.msahoo.springbootaws.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    private DepartmentRepository repository;

    public DepartmentService(DepartmentRepository repository) {
        this.repository = repository;
    }

    public List<Department> findAllDepartments() {
        List<Department> departments = repository.findAll();
        if(departments.isEmpty()) {
            return null;
        }
        return departments;
    }

    public List<Department> findDepartmentsByName(String departmentName) {
        List<Department> departments = repository.findByDepartmentName(departmentName);
        if(departments.isEmpty()) {
            return null;
        }
        return departments;
    }

    public Department findDepartmentById(int id) {
        Optional<Department> department = repository.findById(id);
        return department.orElse(null);
    }

    public Department createDepartment(Department department) {
        return repository.insert(department);
    }

    public void deleteDepartmentById(int id) {
        repository.deleteById(id);;
    }
}
