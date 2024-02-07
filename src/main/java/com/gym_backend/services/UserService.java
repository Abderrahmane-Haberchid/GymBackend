package com.gym_backend.services;

import com.gym_backend.models.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findUserByEmail(String email);
}
