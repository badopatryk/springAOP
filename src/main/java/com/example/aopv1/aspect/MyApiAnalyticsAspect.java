package com.example.aopv1.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {
    @Before("com.example.aopv1.aspect.AopDeclarations.forDaoPackageNotMakeOrDoMethods()")
    public void performingApiAnalytics() {
        System.out.println("\n ---> performing API analytics");
    }

}
