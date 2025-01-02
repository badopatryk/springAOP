package com.example.aopv1;

import com.example.aopv1.dao.AccountDAO;
import com.example.aopv1.dao.MembershipDAO;
import com.example.aopv1.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Aopv1Application {

    public static void main(String[] args) {
        SpringApplication.run(Aopv1Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO membershipDAO, TrafficFortuneService trafficFortuneService) {
        return runner -> {
            //beforeAdvice(theAccountDAO, membershipDAO);
            //afterReturningAdvice(theAccountDAO);
            //afterThrowingAdvice(theAccountDAO);
            //afterAdvice(theAccountDAO);
            //aroundAdvice(trafficFortuneService);
            aroundAdviceExceptionHandling(trafficFortuneService);
        };
    }

    private void aroundAdviceExceptionHandling(TrafficFortuneService trafficFortuneService) {
        System.out.println("Main program: aroundAdviceExceptionHandling");

        System.out.println("Calling getFortune()");

        boolean breakCode = true;

        String fortune = trafficFortuneService.getFortune(breakCode);

        System.out.println("My fortune is: " + fortune);
    }

    private void aroundAdvice(TrafficFortuneService trafficFortuneService) {
        System.out.println("Main program: aroundAdvice");

        System.out.println("Calling getFortune()");

        String fortune = trafficFortuneService.getFortune();

        System.out.println("My fortune is: " + fortune);
    }

    private void afterAdvice(AccountDAO theAccountDAO) {
        List<Account> theAccounts = null;

        try {
            boolean breakCode = false;
            theAccounts = theAccountDAO.findAccounts(breakCode);

        } catch (Exception exception) {
            System.out.println("Caught exception: " + exception);
        }


        System.out.println("Main program: afterThrowingAdvice");
        System.out.println(theAccounts);
    }

    private void afterThrowingAdvice(AccountDAO theAccountDAO) {
        List<Account> theAccounts = null;

        try {
            boolean breakCode = true;
            theAccounts = theAccountDAO.findAccounts(breakCode);

        } catch (Exception exception) {
            System.out.println("Caught exception: " + exception);
        }


        System.out.println("Main program: afterThrowingAdvice");
        System.out.println(theAccounts);
    }

    private void afterReturningAdvice(AccountDAO theAccountDAO) {
        List<Account> theAccounts = theAccountDAO.findAccounts();

        System.out.println("Main program: afterReturningAdvice");
        theAccounts.forEach(System.out::println);
    }

    private void beforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
        Account account = new Account();
        account.setName("Pat");

        theAccountDAO.addAccount(account, true);
        theAccountDAO.doWork();
        theAccountDAO.makeProgress();

        theMembershipDAO.addAccount();
        theMembershipDAO.goToSleep();
        theMembershipDAO.addAccount();
    }

}
