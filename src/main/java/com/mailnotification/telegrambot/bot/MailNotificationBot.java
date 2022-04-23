package com.mailnotification.telegrambot.bot;

import com.mailnotification.telegrambot.model.TelegramUser;
import com.mailnotification.telegrambot.serviceinterface.ITelegramUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

@Component
public class MailNotificationBot extends TelegramLongPollingBot {
	
	private @Value(value = "${token}") String token;

    private static final Logger logger = LoggerFactory.getLogger(MailNotificationBot.class);

    private ITelegramUserService iTelegramUserService;

    @Autowired
    public void setITelegramUserService(ITelegramUserService iTelegramUserService) {
        this.iTelegramUserService = iTelegramUserService;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {

            Message message = update.getMessage();
            long chatId = message.getChatId();

            TelegramUser user = iTelegramUserService.findByChatId(chatId);

            if (user == null) {

                user = new TelegramUser();
                user.setChatid(chatId);
                user.setUsername(message.getChat().getUserName());
                user.setFirstname(message.getChat().getFirstName());
                user.setLast_name(message.getChat().getLastName());
                user.setLanguagecode(message.getFrom().getLanguageCode());
                user.setState(false);

                iTelegramUserService.save(user);

                SendMessage response = new SendMessage();
                response.setChatId(chatId);
                response.setText("You are registered.\n" + " Please wait for admin confirmation");

                try {
                    execute(response);
                } catch (TelegramApiException e) {

                }
            }
        }

    }

    @Override
    public String getBotUsername() {
        // TODO
        // Return bot username
        // If bot username is @MyAmazingBot, it must return 'MyAmazingBot'
        return "mail_notification_bot";
    }

    @Override
    public String getBotToken() {
        // TODO
        // Return bot token from BotFather
        return token;
    }


}