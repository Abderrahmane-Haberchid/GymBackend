package com.gym_backend.services.Impl;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3Object;
import com.gym_backend.dto.UserDto;
import com.gym_backend.repository.UserRepository;
import com.gym_backend.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    public UserDto findUserByEmail(String email){
        var user = userRepository.findByEmail(email).get();

        return UserDto.builder()
                .email(user.getEmail())
                .username(user.getUsername())
                .created_at(user.getCreated_at())
                .authorities(user.getRole())
                .membreSet(user.getMembreSet())
                .suppSet(user.getSuppSet())
                .paiementsSet(user.getPaiementsSet())
                .saleSet(user.getSaleSet())
                .build();
    }
}
