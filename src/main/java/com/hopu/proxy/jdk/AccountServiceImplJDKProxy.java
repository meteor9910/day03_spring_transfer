package com.hopu.proxy.jdk;

import com.hopu.Service.AccountService;
import com.hopu.Service.Impl.AccountServiceImpl;
import com.hopu.dao.AccountDao;
import com.hopu.tx.TxManger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@Service
public class AccountServiceImplJDKProxy implements InvocationHandler, org.springframework.cglib.proxy.InvocationHandler {

    @Autowired
    private AccountServiceImpl accountService;
    @Autowired
    private TxManger txManger;



    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            txManger.begin();
            method.invoke(accountService,args);
//            txManger.commit();
        } catch (Exception e) {
            e.printStackTrace();
//            txManger.rollback();
        } finally {
            txManger.close();
        }
        return null;
    }
}
