package com.hopu.Service.Impl;

import com.hopu.Service.AccountService;
import com.hopu.dao.AccountDao;
import com.hopu.domain.Account;
import com.hopu.tx.TxManger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl  {
    //    引入AccountDao属性
    @Autowired
    private AccountDao accountDao;
    @Autowired
    private TxManger txManger;



    public void transfer(String fromName, String toName, int balance) {
        try {


            //先查询账户信息
            txManger.begin();
            Account fromAccount = accountDao.findByName(fromName);
            Account toAccount = accountDao.findByName(toName);
            //对帐户进行转账的增减操作
            fromAccount.setBalance(fromAccount.getBalance() - balance);
            toAccount.setBalance(toAccount.getBalance() + balance);

            //进行数据的更新
            accountDao.updateByName(fromAccount);
            accountDao.updateByName(toAccount);

//            txManger.commit();


        } catch (Exception e) {
            e.printStackTrace();
//            txManger.rollback();
        } finally {
            txManger.close();
        }
    }
}

