package com.todolist.service;

import com.todolist.dto.request.LoginRequest;
import com.todolist.dto.request.SignUpRequest;
import com.todolist.dto.response.TokenResponse;

public interface AuthService {
    void register(SignUpRequest signupRequest);

    TokenResponse login(LoginRequest loginRequest);
}
