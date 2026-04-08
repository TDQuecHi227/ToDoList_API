package com.todolist.service;

import com.todolist.dto.request.ToDoRequest;
import com.todolist.entity.ToDo;
import java.util.List;

public interface ToDoListService {
    List<ToDo> findAllByUserName(String userName);

    ToDo createToDo(ToDoRequest toDoRequest, String userName);

    ToDo updateToDo(Long id, ToDoRequest toDoRequest, String userName);

    void deleteToDo(Long id, String userName);
}
