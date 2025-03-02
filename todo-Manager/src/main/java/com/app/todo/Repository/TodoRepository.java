package com.app.todo.Repository;

import com.app.todo.pojos.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo,Integer>
{
}
