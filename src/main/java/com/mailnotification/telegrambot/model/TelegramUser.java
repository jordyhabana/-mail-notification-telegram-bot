package com.mailnotification.telegrambot.model;

import javax.persistence.*;

@Entity
@Table(name = "telegramusers")
public class TelegramUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "chatid")
    private long chatid;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "username")
    private String username;

    @Column(name = "languagecode")
    private String languagecode;

    @Column(name = "state")
    private boolean state;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getChatid() {
        return chatid;
    }

    public void setChatid(long chatid) {
        this.chatid = chatid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLanguagecode() {
        return languagecode;
    }

    public void setLanguagecode(String languagecode) {
        this.languagecode = languagecode;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
