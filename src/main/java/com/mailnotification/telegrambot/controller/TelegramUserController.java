package com.mailnotification.telegrambot.controller;

import com.mailnotification.telegrambot.model.TelegramUser;
import com.mailnotification.telegrambot.serviceinterface.ITelegramUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class TelegramUserController {

    private ITelegramUserService iTelegramUserService;

    @Autowired
    public void setITelegramUserService(ITelegramUserService iTelegramUserService){
           this.iTelegramUserService = iTelegramUserService;
    }

    @GetMapping("/telegramusers")
    public List<TelegramUser> telegramUsers(){
        return iTelegramUserService.findAll();
    }


    @PostMapping("/telegramusers/")
    public void postTelegramUser(@RequestBody TelegramUser telegramUser){
        iTelegramUserService.save(telegramUser);
    }


}
