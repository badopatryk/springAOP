package com.example.aopv1;

import com.example.aopv1.dao.AccountDAO;
import com.example.aopv1.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Aopv1Application {

	public static void main(String[] args) {
		SpringApplication.run(Aopv1Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO membershipDAO){
		return runner -> {
			beforeAdvice(theAccountDAO, membershipDAO);

		};

	}

	private void beforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
		theAccountDAO.addAccount();
		theMembershipDAO.addAccount();
	}

}
