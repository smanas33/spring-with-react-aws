package com.msahoo.springbootaws.repository;

import com.msahoo.springbootaws.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseJDBCRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.insert(new Course(1, "Aws", "Udemy"));
        repository.insert(new Course(2, "Azure", "Linkedin"));
        repository.insert(new Course(3, "DevOps", "O'reilly"));

        repository.deleteById(1);

        System.out.println(repository.findByID(2));
        System.out.println(repository.findByID(3));
    }
}
