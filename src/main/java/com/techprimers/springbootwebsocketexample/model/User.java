package com.techprimers.springbootwebsocketexample.model;

import java.security.Principal;

public class User implements Principal {

    private String name;



    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
