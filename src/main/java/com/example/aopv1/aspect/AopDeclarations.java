package com.example.aopv1.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopDeclarations {
    @Pointcut("execution(* com.example.aopv1.dao.*.make*(..))")
    public void makePrefixInDao() {
    }

    @Pointcut("execution(* com.example.aopv1.dao.*.do*(..))")
    public void doPrefixInDao() {
    }

    @Pointcut("execution(* com.example.aopv1.dao.*.*(..))")
    public void forDaoPackage() {
    }

    @Pointcut("forDaoPackage() && !(doPrefixInDao() || makePrefixInDao())")
    public void forDaoPackageNotMakeOrDoMethods() {
    }
}
