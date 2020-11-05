package com.hopu.domain;

import java.io.Serializable;

public class Account implements Serializable {
    private int aid;
    private String name;
    private int balance;

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Account(int aid, String name, int balance) {
        this.aid = aid;
        this.name = name;
        this.balance = balance;
    }

    public Account() {
    }

}
