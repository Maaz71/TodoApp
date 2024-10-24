package com.app.todo.Controllers;

import com.app.todo.pojos.Todo;
import com.app.todo.services.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/todos")
public class TodoContoller {

    Logger logger = LoggerFactory.getLogger(TodoContoller.class);

    @Autowired
    private TodoService todoService;
    Random random = new Random();


    @PostMapping
    public ResponseEntity<Todo> createTodoHandler(@RequestBody Todo todo)
    {
        int id = random.nextInt(99999);
        todo.setId(id);
       logger.info("created Todo");

       Todo todo1=todoService.createTodo(todo);
       return new ResponseEntity<>(todo1, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodoHandler()
    {
       List<Todo> allTodos= todoService.getAllTodo();
       return new ResponseEntity<>(allTodos, HttpStatus.OK);
    }


}
