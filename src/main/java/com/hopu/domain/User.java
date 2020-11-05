package com.hopu.domain;

import lombok.Data;

@Data
public class User {
    private int id;
    private String username;
    private Integer password;

    private Address address;

    public User() {
    }

    public User(int id, String username, Integer password, Address address) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
