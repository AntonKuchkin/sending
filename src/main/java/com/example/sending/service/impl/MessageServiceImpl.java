package com.example.sending.service.impl;

import com.example.sending.controller.dto.MessageRequest;
import com.example.sending.entity.MessageEntity;
import com.example.sending.entity.UserEntity;
import com.example.sending.mapper.MessageMapper;
import com.example.sending.repository.MessageRepository;
import com.example.sending.service.TelegramBot;
import com.example.sending.service.api.MessageService;
import com.example.sending.service.api.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;
    private final UserService userService;
    private final MessageMapper messageMapper;
    private final TelegramBot telegramBot;

    @Override
    public void sendMessageTelegram(MessageRequest message) {
        UserEntity user = userService.getUserByTelegramAccount(message.getTelegramAccount());
        MessageEntity newMessage = messageMapper.toMessageEntity(message);
        List<UserEntity> users = new ArrayList<>();
        users.add(user);
        newMessage.setUsers(users);
        messageRepository.save(newMessage);
        telegramBot.sendMessage(user.getChatId(), message.getMessage());
    }
}
