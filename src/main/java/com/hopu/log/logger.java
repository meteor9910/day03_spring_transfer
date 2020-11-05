package com.hopu.log;


import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect//这就是一个切面[切点 + 增强]
public class logger {
    //定义切点
    @Pointcut("execution(* com.hopu.dao.impl.*.*(..))")
    public void pt() {
    }

    @Before("pt()")
//    @Before("execution(* com.hopu.dao.impl.*.*(..))")
    public void aaa() {
        System.out.println("方法之前...");
    }

    //    @After("execution(* com.hopu.dao.impl.*.*(..))")
    @AfterReturning("pt()")
    public void afterMethod() {
        System.out.println("方法之后...");
    }

    @AfterThrowing("pt()")
    public void exceptionMethod() {
        System.out.println("发生异常了...");
    }

    @After("pt()")
    public void lastMethod() {
        System.out.println("程序运行到最后了...");
    }

}
