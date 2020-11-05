package com.hopu;


import com.hopu.Service.AccountService;
import com.hopu.Service.Impl.AccountServiceImpl;
import com.hopu.proxy.jdk.AccountServiceImplJDKProxy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class) // 指定测试运行器
@ContextConfiguration("classpath:applicationContext.xml") // 指定配置文件
public class transferTest {
    @Autowired
    private AccountServiceImplJDKProxy accountServiceImplJDKProxy;
    @Test
    public void testTransfer(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(AccountServiceImpl.class);
        enhancer.setCallback(accountServiceImplJDKProxy);
        AccountServiceImpl proxyStancer = (AccountServiceImpl) enhancer.create();
        proxyStancer.transfer("tom","张三",1000);
        System.out.println("转账成功");
    }

}
