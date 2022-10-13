        package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {


		// read spring sonfig java class
		AnnotationConfigApplicationContext context 
									=new AnnotationConfigApplicationContext (DemoConfig.class);
		
		//get the bean from sppring container
		
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);		
		//GET MEMBERSGIP BEAN
		
		//call method to find the accounts
		
		List<Account> theAccounts =theAccountDAO.findAccounts();
		
		//display the accounts
		
		System.out.println("\n\n Main Program: AfterReturningDemoAPP");
		
		System.out.println("----");
		
		System.out.println(theAccounts);
		
		System.out.println("\n----");

		
		context.close();
	}

}
