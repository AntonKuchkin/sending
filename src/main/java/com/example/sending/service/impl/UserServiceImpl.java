package com.example.sending.service.impl;

import com.example.sending.controller.dto.UserRequest;
import com.example.sending.controller.dto.UserResponse;
import com.example.sending.entity.UserEntity;
import com.example.sending.exception.UserNotFoundException;
import com.example.sending.mapper.UserMapper;
import com.example.sending.repository.UserRepository;
import com.example.sending.service.api.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserEntity getUserByEmail(@NonNull String email) {

        try {
            return userRepository.findByEmail(email);
        } catch (RuntimeException exception) {
            throw UserNotFoundException.createByName(email);
        }
    }

    @Override
    public UserEntity getUserByTelegramAccount(String telegramAccount) {

        try {
            return userRepository.findByTelegramAccount(telegramAccount);
        } catch (RuntimeException exception) {
            throw UserNotFoundException.createByName(telegramAccount);
        }
    }

    @Override
    public void createUser(UserRequest userRequest) {
        userRepository.save(userMapper.toUserEntity(userRequest));
    }


    @Override
    public void deleteUser(String telegramAccount) {

        UserEntity user = userRepository.findByTelegramAccount(telegramAccount);
        userRepository.delete(user);
    }

    @Override
    @Transactional
    public UserResponse softUpdateUserName(String email, String userName) {

        UserEntity user = getUserByEmail(email);
        user.setUserName(userName);
        userRepository.save(user);
        return userMapper.toUserResponse(user);
    }

    @Override
    public void saveUserTelegram(Long chatId, String telegramAccount) {

        UserEntity user = new UserEntity();
        user.setChatId(chatId);
        user.setTelegramAccount(telegramAccount);
        userRepository.save(user);
    }


}
