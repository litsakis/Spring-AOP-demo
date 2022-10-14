        package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;

public class AfterthrowingDemoApp {

	public static void main(String[] args) {


		// read spring sonfig java class
		AnnotationConfigApplicationContext context 
									=new AnnotationConfigApplicationContext (DemoConfig.class);
		
		//get the bean from sppring container
		
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);		
		//GET MEMBERSGIP BEAN
		
		//call method to find the accounts
		
		//List<Account> theAccounts =theAccountDAO.findAccounts();
		List<Account> theAccounts = null;
		
		try {
			
			//add a boolean flag to simulate exceptions
			boolean tripWire = true;
			theAccounts = theAccountDAO.findAccounts(tripWire);

		}
		catch(Exception exc) {
			
			System.out.println("\n\n Main Program ... caught exception: "+exc);
			
		}
		//display the accounts
		
		System.out.println("\n\n Main Program: AfterThrowingDemoAPP");
		
		System.out.println("----");
		
		System.out.println(theAccounts);
		
		System.out.println("\n----");

		
		context.close();
	}

}
