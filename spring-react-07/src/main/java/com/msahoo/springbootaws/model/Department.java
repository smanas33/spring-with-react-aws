package com.msahoo.springbootaws.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "departments")
public class Department {

    @Id
    private Integer departmentId;
    private String departmentName;
    private String description;
    private List<Employee> employees;

    public Department(Integer departmentId, String departmentName, String description, List<Employee> employees) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.description = description;
        this.employees = employees;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", description='" + description + '\'' +
                ", employee=" + employees +
                '}';
    }
}
