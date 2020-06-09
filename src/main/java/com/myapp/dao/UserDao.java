package com.myapp.dao;

import model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDao {
    Map<String, User> users = new HashMap<String, User>() {
        {
            put("Jack", new User("John", "Jack", 700));
            put("BB", new User("Bob", "Dilan", 3000));
            put("CC", new User("Alicia", "Keys", 4000));
        }
    };

    public User findUser(String id) {
        return users.get(id);
    }

    public List<User> findAllList(){
        return new ArrayList<>(users.values());
    }

    public void addUser(String key, User user) {
        this.users.put(key, user);
    }
}
