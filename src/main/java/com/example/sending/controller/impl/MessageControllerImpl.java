package com.example.sending.controller.impl;

import com.example.sending.controller.api.MessageController;
import com.example.sending.controller.dto.MessageRequest;
import com.example.sending.service.api.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MessageControllerImpl implements MessageController {

    private final MessageService messageService;

    @Override
    public void sendMessageTelegram(MessageRequest message) {
        messageService.sendMessageTelegram(message);
    }
}
