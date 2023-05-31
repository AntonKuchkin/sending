package com.example.sending.controller.api;

import com.example.sending.controller.dto.MessageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;

public interface MessageController {

    @PostMapping("/message")
    @ResponseStatus(HttpStatus.CREATED)
    void sendMessageTelegram(@RequestBody @Valid MessageRequest message);

}
