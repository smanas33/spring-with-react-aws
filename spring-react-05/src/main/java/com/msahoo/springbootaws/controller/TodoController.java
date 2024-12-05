package com.msahoo.springbootaws.controller;

import com.msahoo.springbootaws.model.Todo;
import com.msahoo.springbootaws.repository.TodoRepository;
import com.msahoo.springbootaws.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoController {

    private TodoService todoService;
    private TodoRepository todoRepository;

    public TodoController(TodoService todoService, TodoRepository todoRepository) {
        super();
        this.todoService = todoService;
        this.todoRepository = todoRepository;
    }

    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap model) {
        String userName = getLoggedInUserName(model);
        List<Todo> todos = todoRepository.findByUsername(userName);
        model.put("todos", todos);
        return "listTodos";
    }

    @RequestMapping(value="add-todo", method=RequestMethod.GET)
    public String showNewTodoPage(ModelMap model) {
        String userName = getLoggedInUserName(model);
        Todo todo = new Todo(0, userName, "", LocalDate.now().plusYears(1), false);
        model.put("todo", todo);
        return "todo";
    }

    @RequestMapping(value="add-todo", method=RequestMethod.POST)
    public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "todo";
        }
        String userName = getLoggedInUserName(model);
        todo.setUserName(userName);
        todoRepository.save(todo);
//        todoService.addTodo(userName, todo.getDescription(), todo.getTargetDate(), todo.isDone());
        return "redirect:list-todos";
    }

    @RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam int id) {
//        todoService.deleteTodoById(id);
        todoRepository.deleteById(id);
        return "redirect:list-todos";
    }

    @RequestMapping(value="update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
        Todo todo = todoRepository.findById(id).get();
        model.addAttribute("todo", todo);
        return "todo";
    }

    @RequestMapping(value="update-todo", method = RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "todo";
        }

        String userName = getLoggedInUserName(model);
        todo.setUserName(userName);
        todoRepository.save(todo);
//        todoService.updateTodo(todo);
        return "redirect:list-todos";
    }

    private static String getLoggedInUserName(ModelMap model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

}
