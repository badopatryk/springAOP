package com.example.aopv1.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLoggingAspect {
    @Before("execution(public void add*())")
    public void beforeAddAccountAdvice(){
        System.out.println("\n ---> executing @Before advice on any method");
    }
}
