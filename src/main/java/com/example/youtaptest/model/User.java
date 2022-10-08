package com.example.youtaptest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    private final int id;
    private final String username;
    private final String Email;
    private final String Phone;

    public User(@JsonProperty("id") int id, @JsonProperty("username") String username, @JsonProperty("email") String email, @JsonProperty("phone") String phone) {
        this.id = id;
        this.username = username;
        this.Email = email;
        this.Phone = phone;
    }

    public User() {
        this.id = -1;
        this.username = "";
        this.Email = "";
        this.Phone = "";
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return Email;
    }

    public String getPhone() {
        return Phone;
    }
}
