package com.msahoo.springbootaws.repository;

import com.msahoo.springbootaws.model.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends MongoRepository<Department, Integer> {
    List<Department> findByDepartmentName(String departmentName);

}
