package com.example.youtaptest.service;

import com.example.youtaptest.dao.UserDao;
import com.example.youtaptest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserDao userDao;

    @Autowired
    public UserService(@Qualifier("ExternalAPI") UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getAllUsers() {
        return userDao.selectAllUsers();
    }

    public Optional<User> getUserById(int id) {
        return userDao.selectUserById(id);
    }

    public Optional<User> getUserByUsername(String username) {
        return userDao.selectUserByUsername(username);
    }

}
