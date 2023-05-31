package com.example.sending.service;

import com.example.sending.config.BotConfig;
import com.example.sending.service.api.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Slf4j
@Component
@RequiredArgsConstructor
public class TelegramBot extends TelegramLongPollingBot {

    private final BotConfig botConfig;
    private final UserService userService;

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            Long chatId = update.getMessage().getChatId();
            switch (messageText) {
                case "/start":
                    startCommandReceived(chatId, update.getMessage().getChat().getUserName());
                    break;
                default:
                    sendMessage(chatId, "что не то");
            }
        }
    }

    @Override
    public String getBotUsername() {

        return botConfig.getBotName();
    }

    @Override
    public String getBotToken() {

        return botConfig.getToken();
    }


    private void startCommandReceived(Long chatId, String name) {

        String answer = "Привет, " + name + " !";
        log.info("Replied to user" + name);
        sendMessage(chatId, answer);
        userService.saveUserTelegram(chatId, name);
    }

    public void sendMessage(Long chatId, String textToSend) {

        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(textToSend);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            log.error("Error occurred: " +e.getMessage());
        }
    }
}

