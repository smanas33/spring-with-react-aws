package com.msahoo.springbootaws.service;

import com.msahoo.springbootaws.model.Todo;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();

    private static int todosCount = 0;

    static {
        todos.add(new Todo(++todosCount, "udemy", "AWS", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++todosCount, "udemy", "DevOps", LocalDate.now().plusYears(2), false));
        todos.add(new Todo(++todosCount, "udemy", "Azure", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++todosCount, "udemy", "FullStack", LocalDate.now().plusYears(3), false));
    }

    public List<Todo> findByUsername(String userName) {
        Predicate<? super Todo> predicate = todo -> todo.getUserName().equalsIgnoreCase(userName);
        return todos.stream().filter(predicate).toList();
    }

    public void addTodo(String userName, String description, LocalDate targetDate, boolean isDone) {
        Todo todo = new Todo(++todosCount, userName, description, targetDate, isDone);
        todos.add(todo);
    }

    public void deleteTodoById(int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        todos.removeIf(predicate);
    }

    public void updateTodo(@Valid Todo todo) {
        deleteTodoById(todo.getId());
        todos.add(todo);
    }

    public Todo findById(int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        return todos.stream().filter(predicate).findFirst().get();
    }
}
