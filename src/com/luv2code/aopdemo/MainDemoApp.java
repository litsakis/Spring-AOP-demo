        package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {


		// read spring sonfig java class
		AnnotationConfigApplicationContext context 
									=new AnnotationConfigApplicationContext (DemoConfig.class);
		
		//get the bean from sppring container
		
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);		
		//GET MEMBERSGIP BEAN
		
		MembershipDAO theMembershipDAO = 
				context.getBean("membershipDAO", MembershipDAO.class);
		
		// call the business method
		theAccountDAO.addAccount();
		
		
		//call the membership busisness method
		theMembershipDAO.addAccount();
		
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("selver");
		
		
		String name=theAccountDAO.getName();
		String code=theAccountDAO.getServiceCode();
			
		
		//close
		
		context.close();
	}

}
