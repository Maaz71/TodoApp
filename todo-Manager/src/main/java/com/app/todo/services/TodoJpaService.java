package com.app.todo.services;

import com.app.todo.pojos.Todo;

import java.text.ParseException;
import java.util.List;

public interface TodoJpaService {

    public Todo createTodo(Todo todo);
    public List<Todo>getAllTodos();
    public Todo getTodo(int todoId) throws ParseException;
    public Todo updateTodo(int todoId, Todo todo);
    public void deleteTodo(int todoId);
}
