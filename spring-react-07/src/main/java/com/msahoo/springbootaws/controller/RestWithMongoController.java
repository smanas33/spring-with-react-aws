package com.msahoo.springbootaws.controller;

import com.msahoo.springbootaws.exception.UserNotFoundException;
import com.msahoo.springbootaws.model.Department;
import com.msahoo.springbootaws.model.Employee;
import com.msahoo.springbootaws.service.DepartmentService;
import com.msahoo.springbootaws.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class RestWithMongoController {

    private DepartmentService departmentService;
    private EmployeeService employeeService;

    public RestWithMongoController(DepartmentService departmentService, EmployeeService employeeService) {
        this.departmentService = departmentService;
        this.employeeService = employeeService;
    }

    ///////////////////////////////////////////////////////////
    //                  Employee Details                     //
    ///////////////////////////////////////////////////////////

    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        Employee employee = employeeService.findEmployeeById(id);

        if(employee == null) {
            throw new UserNotFoundException("id: " + id);
        }
        return employee;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.findAllEmployees();
    }

    @PostMapping("/employees/name")
    public List<Employee> getAllEmployeesByName(@RequestParam String employeeName) {
        System.out.println("My name is: " + employeeName);
        return employeeService.findEmployeesByName(employeeName);
    }

    @PostMapping("/employees/department/name")
    public List<Employee> getAllEmployeesByDepartmentName(@RequestParam String departmentName) {
        return employeeService.findByDepartmentName(departmentName);
    }

    @PostMapping("/employee")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.createEmployee(employee);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(savedEmployee.getEmpId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/employee")
    public void updateEmployee(@RequestBody Employee employee) {
        employeeService.createEmployee(employee);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployeeById(@PathVariable int id) {
        employeeService.deleteEmployeeById(id);
    }

    ////////////////////////////////////////////////////////////
    //                  Department Details                    //
    ////////////////////////////////////////////////////////////

    @GetMapping("/department/{id}")
    public Department getDepartmentById(@PathVariable int id) {
        Department department = departmentService.findDepartmentById(id);

        if(department == null) {
            throw new UserNotFoundException("id: " + id);
        }
        return department;
    }

    @GetMapping("/departments")
    public List<Department> getAllDepartments() {
        return departmentService.findAllDepartments();
    }

    @PostMapping("/departments/departmentName")
    public List<Department> getAllDepartmentsByName(@RequestParam String departmentName) {
        return departmentService.findDepartmentsByName(departmentName);
    }

    @PostMapping("/department")
    public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
        Department savedDepartment = departmentService.createDepartment(department);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(savedDepartment.getDepartmentId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/department")
    public void updateDepartment(@RequestBody Department department) {
        departmentService.createDepartment(department);
    }

    @DeleteMapping("/departments/{id}")
    public void deleteDepartmentById(@PathVariable int id) {
        departmentService.deleteDepartmentById(id);
    }
}
