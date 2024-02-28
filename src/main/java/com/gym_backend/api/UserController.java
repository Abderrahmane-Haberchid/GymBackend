package com.gym_backend.api;

import com.gym_backend.dto.UserDto;
import com.gym_backend.models.User;
import com.gym_backend.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{email}")
    public ResponseEntity<UserDto> findById(@PathVariable String email){
            return ResponseEntity.ok(userService.findUserByEmail(email));
    }
}
