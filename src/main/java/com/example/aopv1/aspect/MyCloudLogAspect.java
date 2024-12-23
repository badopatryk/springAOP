package com.example.aopv1.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAspect {
    @Before("com.example.aopv1.aspect.AopDeclarations.forDaoPackageNotMakeOrDoMethods()")
    public void logToCloud() {
        System.out.println("\n ---> logging to cloud");
    }
}
