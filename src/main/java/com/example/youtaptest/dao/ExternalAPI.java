package com.example.youtaptest.dao;

import com.example.youtaptest.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository("ExternalAPI")
public class ExternalAPI implements UserDao {

    @Override
    public List<User> selectAllUsers() {
        String uri = "https://jsonplaceholder.typicode.com/users";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<User[]> response = restTemplate.getForEntity(uri, User[].class);
        return Arrays.stream(response.getBody()).toList();
    }

    @Override
    public Optional<User> selectUserById(int id) {
        return selectAllUsers().stream()
                .filter(user -> user.getId() == id).findFirst();
    }

    @Override
    public Optional<User> selectUserByUsername(String username) {
        return selectAllUsers().stream()
                .filter(user -> user.getUsername().equals(username)).findFirst();
    }


}
