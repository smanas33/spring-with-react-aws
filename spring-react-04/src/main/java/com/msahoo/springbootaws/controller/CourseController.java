package com.msahoo.springbootaws.controller;

import com.msahoo.springbootaws.model.Course;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {

    @RequestMapping("/courses")
    public List<Course> retrieveAllCourses() {
        return Arrays.asList(
                new Course(1, "AWS", "udemy"),
                new Course(2, "DevOps", "udemy")
        );
    }
}
