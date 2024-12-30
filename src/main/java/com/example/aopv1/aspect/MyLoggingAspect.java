package com.example.aopv1.aspect;

import com.example.aopv1.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyLoggingAspect {

    @After("execution(* com.example.aopv1.dao.AccountDAO.findAccounts(..))")
    public void findAccountsAfterAdvice(JoinPoint joinPoint){

        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n ---> executing @After advice on method: " + method);
    }

    @AfterThrowing(pointcut = "execution(* com.example.aopv1.dao.AccountDAO.findAccounts(..))",
    throwing = "exception")
    public void findAccountsAfterThrowingAdvice(JoinPoint joinPoint,Throwable exception){
        String method = joinPoint.getSignature().toShortString();

        System.out.println("\n ---> executing @AfterThrowing advice on method: " + method);

        System.out.println("\n ---> the exception is: " + exception);
    }

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

    @AfterReturning(pointcut = "execution(* com.example.aopv1.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void findAccountsAfterReturningAdvice(JoinPoint joinPoint, List<Account> result) {
        String method = joinPoint.getSignature().toShortString();

        System.out.println("\n ---> executing @AfterReturning on method: " + method);

        System.out.println("\n ---> result: " + result);

        // post-processing retrieved data

        convertAccountNamesToLowerCase(result);

        System.out.println("\n ---> result after modification: " + result);
    }

    private void convertAccountNamesToLowerCase(List<Account> result) {
        result.forEach(account -> account.setName(account.getName().toLowerCase()));
    }

}
