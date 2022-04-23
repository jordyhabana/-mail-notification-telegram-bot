package com.mailnotification.telegrambot.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="users", uniqueConstraints = { //
        @UniqueConstraint(name = "user_uk", columnNames = "username") })
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="username", length = 36, nullable = false)
    private String username;

    @Column(name="password", nullable = false)
    private String password;

    @ManyToMany
    private Set<Rol> roles;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }
}
