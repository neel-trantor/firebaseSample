package com.neel.firebasenotifications.model;

import com.google.firebase.database.IgnoreExtraProperties;

import java.util.Date;

@IgnoreExtraProperties
public class User {
 
    public String name;
    public String email;
    public String currentDate;
 
    // Default constructor required for calls to
    // DataSnapshot.getValue(User.class)
    public User() {
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
    public User(String name, String email, String currentDate) {
        this.name = name;
        this.email = email;
        this.currentDate = currentDate;
    }
}