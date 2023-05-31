package com.example.sending.controller.impl;

import com.example.sending.controller.api.UserController;
import com.example.sending.controller.dto.UserRequest;
import com.example.sending.controller.dto.UserResponse;
import com.example.sending.service.api.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

    private final UserService userService;

    @Override
    public void createUser(@NotNull UserRequest user) {
        userService.createUser(user);
    }

    @Override
    public void deleteUser(String telegramAccount) {
        userService.deleteUser(telegramAccount);
    }

    @Override
    public UserResponse softUpdateUserName(String email, String userName) {
        return userService.softUpdateUserName(email, userName);
    }


}
