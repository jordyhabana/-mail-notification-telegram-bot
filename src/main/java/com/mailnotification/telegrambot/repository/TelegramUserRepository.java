package com.mailnotification.telegrambot.repository;

import com.mailnotification.telegrambot.model.TelegramUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelegramUserRepository extends JpaRepository<TelegramUser,Long>{
    TelegramUser findByChatid(long chatid);

}
