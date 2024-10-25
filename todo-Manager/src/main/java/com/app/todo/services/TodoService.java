package com.app.todo.services;

import com.app.todo.pojos.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public Todo getTodo( int todoId) {
        Todo todo =todos.stream().filter(t-> todoId==t.getId()).findAny().get();
        return todo;
    }

    public Todo updateTodo (int todoId, Todo todo) {
        List<Todo> newUpdatedList= todos.stream().map(t->{
            if(t.getId()==todoId)
            {
                t.setTitle(todo.getTitle());
                t.setContent(todo.getContent());
                t.setStatus(todo.getStatus());
                return t;
            }
            else{
                return t;
            }
        }).collect(Collectors.toList());

        todos= newUpdatedList;
        todo.setId(todoId);
        return todo;
    }

    public void deleteTodo(int todoId) {

        List<Todo> newList=todos.stream().filter(t->t.getId()!=todoId).collect(Collectors.toList());
        todos= newList;
    }
}
