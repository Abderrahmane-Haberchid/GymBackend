package com.gym_backend.services;

import com.gym_backend.dto.UserDto;

public interface UserService {
    UserDto findUserByEmail(String email);
}
