package com.app.todo.services;

import com.app.todo.pojos.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TodoService {

    Logger logger = LoggerFactory.getLogger(TodoService.class);

    List<Todo> todos = new ArrayList<>();

    public Todo createTodo(Todo todo)
    {

        todos.add(todo);
        logger.info("Todo {}", this.todos);
        return todo;

    }

    public List<Todo> getAllTodo() {
        return todos;
    }
}
