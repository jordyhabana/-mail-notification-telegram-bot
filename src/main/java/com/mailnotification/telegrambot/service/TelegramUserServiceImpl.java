package com.mailnotification.telegrambot.service;

import com.mailnotification.telegrambot.serviceinterface.ITelegramUserService;
import com.mailnotification.telegrambot.model.TelegramUser;
import com.mailnotification.telegrambot.repository.TelegramUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelegramUserServiceImpl implements ITelegramUserService {

    private TelegramUserRepository telegramUserRepository;

    @Autowired
    public void setTelegramUserRepository(TelegramUserRepository telegramUserRepository){
        this.telegramUserRepository = telegramUserRepository;
    }

    @Override
    public void save(TelegramUser telegramUser) {
        telegramUserRepository.save(telegramUser);
    }

    @Override
    public List<TelegramUser> findAll() {
        return telegramUserRepository.findAll();
    }

    @Override
    public TelegramUser findByChatId( long chatid ){
        return telegramUserRepository.findByChatid(chatid);
    }

    @Override
    public void deleteByChatId(long chatid){
        telegramUserRepository.deleteById(chatid);
    }

}
