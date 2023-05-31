package com.example.sending.service.api;

import com.example.sending.controller.dto.UserRequest;
import com.example.sending.controller.dto.UserResponse;
import com.example.sending.entity.UserEntity;
import lombok.NonNull;

import javax.validation.constraints.NotBlank;

public interface UserService {

    UserEntity getUserByEmail(@NonNull String email);

    UserEntity getUserByTelegramAccount(@NotBlank String telegramAccount);

    void createUser(@NonNull UserRequest userRequest);

    void deleteUser(@NotBlank String telegramAccount);

    UserResponse softUpdateUserName(String email, String userName);

    void saveUserTelegram (Long chatId, String telegramAccount);
}
