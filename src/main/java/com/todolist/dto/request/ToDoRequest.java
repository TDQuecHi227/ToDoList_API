package com.todolist.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ToDoRequest {
    @NotBlank(message = "Title is required")
    private String title;
    private String description;
    @Builder.Default
    private Boolean completed = false;
}
