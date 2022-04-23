package com.mailnotification.telegrambot.repository;

import com.mailnotification.telegrambot.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RolReposiroty extends JpaRepository<Rol,Long> {

   @Query(value = "SELECT roles.id, roles.name FROM roles, users_roles WHERE roles.id = users_roles.roles_id AND users_roles.users_id = ?", nativeQuery = true)
    List<Rol> findAll(long id);
}
