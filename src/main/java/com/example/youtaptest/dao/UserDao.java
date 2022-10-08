package com.example.youtaptest.dao;

import com.example.youtaptest.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {

    List<User> selectAllUsers();

    Optional<User> selectUserById(int id);

    Optional<User> selectUserByUsername(String name);

}
