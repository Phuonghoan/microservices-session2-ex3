package org.example.userservice.service;

import lombok.RequiredArgsConstructor;
import org.example.userservice.dto.UserResponse;
import org.example.userservice.entity.User;
import org.example.userservice.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository
            userRepository;

    public List<UserResponse> getUsers() {

        return userRepository
                .findAll()
                .stream()
                .map(user ->
                        new UserResponse(
                                user.getId(),
                                user.getName(),
                                user.getEmail()
                        )
                )
                .toList();
    }

    public UserResponse createUser(
            User user
    ) {

        User saved =
                userRepository.save(user);


        return new UserResponse(

                saved.getId(),

                saved.getName(),

                saved.getEmail()
        );
    }
}
