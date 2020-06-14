package com.example.playground.ui.login;

import java.io.Serializable;

public class User implements Serializable {
    public String username;
    public Byte[] hashed_password;

    public User(){}

    public User(String username, Byte[] hashed_password){
        this.username = username;
        this.hashed_password = hashed_password;
    }
}
