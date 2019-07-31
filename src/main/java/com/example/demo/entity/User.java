package com.example.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class User implements Serializable{

	private Integer userId;
    private String userName;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public User() {
    }

    public User(String userName, List skills) {
        this.userName = userName;
    }
    public User(Integer id, String userName) {
        this.userId=id;
        this.userName = userName;
    }
}
