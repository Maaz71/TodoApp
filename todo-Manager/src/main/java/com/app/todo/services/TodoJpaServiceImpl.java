package com.app.todo.services;

import com.app.todo.Repository.TodoRepository;
import com.app.todo.pojos.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Primary
@Service
public class TodoJpaServiceImpl implements TodoJpaService {

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    @Override
    public Todo getTodo(int todoId) throws ParseException {
        return todoRepository.findById(todoId).orElseThrow(()-> new RuntimeException("Todo Not found with given ID"));
    }

    @Override
    public Todo updateTodo(int todoId, Todo todo) {
        Todo todo1 = todoRepository.findById(todoId).orElseThrow(() -> new RuntimeException("Todo Not Found"));
        todo1.setTitle(todo.getTitle());
        todo1.setStatus(todo.getStatus());
        todo1.setContent(todo.getContent());
        todo1.setDeadLineDate(todo.getDeadLineDate());
        return todoRepository.save(todo1);
    }

    @Override
    public void deleteTodo(int todoId) {
        Todo todo2 = todoRepository.findById(todoId).orElseThrow(() -> new RuntimeException("Todo Not found"));
        todoRepository.delete(todo2);

    }
}
