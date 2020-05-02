package com.anuragprojects.urlshortener.constant;

import com.anuragprojects.urlshortener.model.User;

import java.util.ArrayList;
import java.util.HashMap;

public class RegisteredUserList {

    public static ArrayList<User> userList = new ArrayList<User>();

    static {
        userList.add(new User("PersonA", "U12345", "Jack"));
        userList.add(new User("PersonB", "U23456", "Jill"));
    }
}
