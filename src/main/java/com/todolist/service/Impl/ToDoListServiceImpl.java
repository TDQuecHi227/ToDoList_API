package com.todolist.service.Impl;

import com.todolist.dto.request.ToDoRequest;
import com.todolist.entity.ToDo;
import com.todolist.entity.User;
import com.todolist.repository.ToDoListRepository;
import com.todolist.repository.UserRepository;
import com.todolist.service.ToDoListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ToDoListServiceImpl implements ToDoListService {
    private final ToDoListRepository toDoListRepository;
    private final UserRepository userRepository;

    @Override
    public List<ToDo> findAllByUserName(String userName) {
        User user = userRepository.findUserByUserName(userName);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        return toDoListRepository.findAllByUser(user);
    }

    @Override
    public ToDo createToDo(ToDoRequest toDoRequest, String userName) {
        User user = userRepository.findUserByUserName(userName);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        ToDo toDo = ToDo.builder()
                .title(toDoRequest.getTitle())
                .description(toDoRequest.getDescription())
                .completed(toDoRequest.getCompleted())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .user(user)
                .build();
        return toDoListRepository.save(toDo);
    }

    @Override
    public ToDo updateToDo(Long id, ToDoRequest toDoRequest, String userName) {
        ToDo oldToDo = toDoListRepository.findById(id).orElseThrow(() -> new RuntimeException("ToDo not found"));
        if (oldToDo.getUser().getUserName().equals(userName)) {
            oldToDo.setTitle(toDoRequest.getTitle());
            oldToDo.setDescription(toDoRequest.getDescription());
            oldToDo.setCompleted(toDoRequest.getCompleted());
            oldToDo.setUpdatedAt(LocalDateTime.now());
            return toDoListRepository.save(oldToDo);
        } else {
            throw new RuntimeException("You are not authorized to update this ToDo");
        }
    }

    @Override
    public void deleteToDo(Long id, String userName) {
        ToDo toDo = toDoListRepository.findById(id).orElseThrow(() -> new RuntimeException("ToDo not found"));
        if (toDo.getUser().getUserName().equals(userName)) {
            toDoListRepository.delete(toDo);
        } else {
            throw new RuntimeException("You are not authorized to delete this ToDo");
        }
    }
}
