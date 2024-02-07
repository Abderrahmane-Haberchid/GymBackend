package com.gym_backend.services.Impl;

import com.gym_backend.models.User;
import com.gym_backend.repository.UserRepository;
import com.gym_backend.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    public Optional<User> findUserByEmail(String email){
        return userRepository.findByEmail(email);
    }
}
