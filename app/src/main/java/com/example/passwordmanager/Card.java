package com.example.passwordmanager;

import com.google.firebase.database.Exclude;

import java.io.Serializable;

public class Card implements Serializable {

    @Exclude
    private String title;
    private String id;
    private String password;
    private String key;

    public Card(){}

    public void setKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public Card(String title , String id , String password){
        this.title = title;
        this.id = id;
        this.password = password;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }
}
