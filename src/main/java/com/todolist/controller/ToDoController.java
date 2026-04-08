package com.todolist.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todolist.dto.request.ToDoRequest;
import com.todolist.entity.ToDo;
import com.todolist.service.ToDoListService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ToDoController {
    private final ToDoListService toDoListService;

    @GetMapping("/todos")
    public ResponseEntity<List<ToDo>> ListToDoUser(Principal principal) {
        String userName = principal.getName();
        return ResponseEntity.ok(toDoListService.findAllByUserName(userName));
    }

    @PostMapping("/todos")
    public ResponseEntity<ToDo> createToDo(@RequestBody ToDoRequest toDoRequest, Principal principal) {
        String userName = principal.getName();
        return ResponseEntity.ok(toDoListService.createToDo(toDoRequest, userName));
    }

    @PutMapping("/todos/{id}")
    public ResponseEntity<ToDo> updateToDo(@PathVariable Long id, @RequestBody ToDoRequest toDoRequest,
            Principal principal) {
        String userName = principal.getName();
        return ResponseEntity.ok(toDoListService.updateToDo(id, toDoRequest, userName));
    }

    @DeleteMapping("/todos/{id}")
    public ResponseEntity<String> deleteToDo(@PathVariable Long id, Principal principal) {
        String userName = principal.getName();
        toDoListService.deleteToDo(id, userName);
        return ResponseEntity.ok("ToDo deleted successfully");
    }
}
