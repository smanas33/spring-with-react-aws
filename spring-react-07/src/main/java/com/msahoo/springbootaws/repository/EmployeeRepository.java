package com.msahoo.springbootaws.repository;

import com.msahoo.springbootaws.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, Integer> {
    List<Employee> findByName(String name);
    List<Employee> findByDepartmentName(String departmentName);
}
