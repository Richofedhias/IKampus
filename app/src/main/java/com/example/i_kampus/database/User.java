package com.example.i_kampus.database;

import android.media.Image;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String noTelfon;
    private String password;
    private String key;
    private String jenisKel;
    private String sekolah;
    private String ImageUrl;

    public User() {
    }

    public User(String firstName, String lastName, String email, String noTelfon) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.noTelfon = noTelfon;
    }

    public User(String firstName, String lastName, String email, String noTelfon, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.noTelfon = noTelfon;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNoTelfon() {
        return noTelfon;
    }

    public void setNoTelfon(String noTelfon) {
        this.noTelfon = noTelfon;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}