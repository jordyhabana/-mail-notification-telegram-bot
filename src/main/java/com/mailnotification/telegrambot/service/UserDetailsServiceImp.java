package com.mailnotification.telegrambot.service;

import com.mailnotification.telegrambot.model.Rol;
import com.mailnotification.telegrambot.model.User;
import com.mailnotification.telegrambot.repository.RolReposiroty;
import com.mailnotification.telegrambot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

    private UserRepository repo;

    private RolReposiroty rolReposiroty;

    @Autowired
    public void setUserRepository(UserRepository repo){
        this.repo = repo;
    }

    @Autowired
    public void setRolRepository(RolReposiroty rolReposiroty){
        this.rolReposiroty = rolReposiroty;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        User user = repo.findUserByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("User not found");
        }

        List<Rol> roleNames = rolReposiroty.findAll(user.getId());

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        if (roleNames != null) {
            for (Rol role : roleNames) {
                GrantedAuthority authority = new SimpleGrantedAuthority(role.getName());
                grantedAuthorities.add(authority);
            }
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                grantedAuthorities);
     }

    public void save(User newuser){
        User user = repo.findUserByUsername(newuser.getUsername());
        if(user == null){
             repo.save(newuser);
        }else{
            System.out.print("This user is in database already");
        }
    }



}
