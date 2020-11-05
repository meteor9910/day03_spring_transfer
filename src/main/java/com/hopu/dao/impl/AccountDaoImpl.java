package com.hopu.dao.impl;

import com.hopu.dao.AccountDao;
import com.hopu.domain.Account;
import com.hopu.tx.TxManger;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository
public class AccountDaoImpl implements AccountDao {
    @Autowired
    private QueryRunner queryRunner;
    @Autowired
    private TxManger txManger;


    @Override
    public Account findByName(String name) {
        try {
            Account account = queryRunner.query(txManger.getConnection(),"SELECT*FROM t_account where name =? ",
                    new BeanHandler<Account>(Account.class),name);
            return account;
        }catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public void updateByName(Account account) {
        try {
            queryRunner.update(txManger.getConnection(),"update t_account set balance=? where name=?",
                    account.getBalance(),account.getName());

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}