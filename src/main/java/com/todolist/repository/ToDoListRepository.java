package com.todolist.repository;

import com.todolist.entity.ToDo;
import com.todolist.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoListRepository extends JpaRepository<ToDo, Long> {
    List<ToDo> findAllByUser(User user);
}
