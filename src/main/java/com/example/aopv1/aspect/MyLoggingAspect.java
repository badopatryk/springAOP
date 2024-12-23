package com.example.aopv1.aspect;

import com.example.aopv1.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyLoggingAspect {

    @Before("com.example.aopv1.aspect.AopDeclarations.forDaoPackageNotMakeOrDoMethods()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("\n ---> executing @Before advice on any method");

        System.out.println("Method: " + joinPoint.getSignature());
        Object[] args = joinPoint.getArgs();

        for (Object obj : args) {
            System.out.println(obj);

            if (obj instanceof Account) {
                Account accountObj = (Account) obj;
                System.out.println("Account name: " + accountObj.getName());
            }
        }
    }
}
