package com.hopu;


import com.hopu.dao.AccountDao;
import com.hopu.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) // 指定测试运行器
@ContextConfiguration("classpath:applicationContext.xml") // 指定配置文件
public class aopTest {
    @Autowired
    private AccountDao accountDao;

    @Test
    public void testTransfer(){
        Account account = accountDao.findByName("张三");
        System.out.println(account);
    }

}
