package com.example.sending.service.api;

import com.example.sending.controller.dto.MessageRequest;

public interface MessageService {

    void sendMessageTelegram (MessageRequest message);

}
