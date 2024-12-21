package com.msahoo.springbootaws.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloWorldController {

    private static final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

    public static final List<Todo> TODOS = List.of(new Todo("Manas", "Learn Aws"),
            new Todo("Manas", "Learn GCP"));

    @GetMapping("/todos")
    public List<Todo> retrieveAllTodos() {
        return TODOS;
    }

    @GetMapping("/users/{username}/todos")
    public Todo retrieveAllTodos(@PathVariable String username) {
        return TODOS.get(0);
    }

    @PostMapping("/users/{username}/todos")
    public void createTodoForUser(@PathVariable String username, @RequestBody Todo todo) {
        logger.info("Creating {} for {}", todo, username);
    }
}

record Todo(String username, String description) {}
