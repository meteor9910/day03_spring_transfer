package com.hopu.dao;
import com.hopu.domain.Account;

public interface AccountDao {

    Account findByName(String name);
    void updateByName(Account account);









}
