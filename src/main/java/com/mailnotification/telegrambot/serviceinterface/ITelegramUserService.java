package com.mailnotification.telegrambot.serviceinterface;

import com.mailnotification.telegrambot.model.TelegramUser;

import java.util.List;

public interface ITelegramUserService {

    void save(TelegramUser telegramUser);

    List<TelegramUser> findAll();

    TelegramUser findByChatId( long chatid );

    void deleteByChatId(long chatid);
}
