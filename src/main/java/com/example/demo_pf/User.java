package com.example.demo_pf;

public class User {
    String username;
    String password;
    public String firstname;
    public String lastname;
    boolean isTeacher;

    public User(String username, String password, String firstname, String lastname, boolean isTeacher) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.isTeacher = isTeacher;
    }
}
