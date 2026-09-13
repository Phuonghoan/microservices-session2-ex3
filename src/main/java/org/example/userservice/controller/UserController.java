package org.example.userservice.controller;

import lombok.RequiredArgsConstructor;
import org.example.userservice.dto.UserResponse;
import org.example.userservice.entity.User;
import org.example.userservice.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService
            userService;

    // Lấy danh sách user
    @GetMapping
    public ResponseEntity<List<UserResponse>>
    getUsers() {

        return ResponseEntity.ok(
                userService.getUsers()
        );
    }

    // Tạo dữ liệu để test
    @PostMapping
    public ResponseEntity<UserResponse>
    createUser(
            @RequestBody User user
    ) {

        return ResponseEntity
                .status(201)
                .body(
                        userService
                                .createUser(user)
                );
    }
}
