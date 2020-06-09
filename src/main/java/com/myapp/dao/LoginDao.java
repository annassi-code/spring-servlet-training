package com.myapp.dao;

import model.Login;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LoginDao {
    Map<String, Login> logins = new HashMap<String,Login>(){
        {
            put("aa@aa.com", new Login("aa@aa.com", "aaa"));
            put("bb@bb.com", new Login("bb@bb.com", "bbb"));
            put("cc@cc.com", new Login("cc@cc.com", "ccc"));
            put("dd@dd.com", new Login("dd@dd.com", "ddd"));
            put("ee@ee.com", new Login("ee@ee.com", "eee"));
            put("ff@ff.com", new Login("ff@ff.com", "fff"));
        }
    };

    public Login findLogin(String id) {
        return this.logins.get(id);
    }

    public List<Login> findAllList(){
        return new ArrayList<Login>(this.logins.values());
    }

    public void addLogin(String key, Login login) {
        this.logins.put(key, login);
    }

    public boolean checkLogin(String email, String password) {
        if(this.logins.containsKey(email)) {
            return this.logins.get(email).getPassword().equals(password) ? true : false;
        }
        else {
            return false;
        }
    }

    public void remove(String id) {
        logins.remove(id);
    }

    public boolean checkAccountLogin(String email) {
        if(logins.containsKey(email)) {
            return true;
        }
        else {
            return false;
        }
    }

    public void create(String email, String password) {
        if(!checkAccountLogin(email)) {
            Login login = new Login(email, password);
            this.addLogin(email, login);
        }
    }
}
