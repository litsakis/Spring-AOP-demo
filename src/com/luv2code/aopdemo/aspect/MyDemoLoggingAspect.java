package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;
import com.luv2code.aopdemo.dao.AccountDAO;

@Aspect
@Component
@Order(0)
public class MyDemoLoggingAspect {
	
	// add a new advice for @AfterReturning on the findAccounts method
	
	@AfterReturning(
			pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result"
			)
	public void afterReturningFindAccountsAdvice(
		JoinPoint theJoinPoint, List<Account> result) {
		
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n==========================>>> Executing @AfterReturning on method: " + method);
		//print out the results of the methods call
		System.out.println("\n==========================>>> result is: : " + result);

		
		
	}
	
	@Before("com.luv2code.aopdemo.aspect.AopExpessions.finalpointcut()")
	public void beforeAddAcoountAdvice(JoinPoint theJoinPoint) {
		
		System.out.println("\n===================>>>>>>>  Executing @beforeAddAcoountAdvice()");
		
		
		
		//display the method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		
		System.out.println("Method: "+methodSig);
		
		//display the method arguments
		//get args
		
		Object[] args= theJoinPoint.getArgs();

		//loop thru arg
				
				for (Object tempArg : args) {
					System.out.println(tempArg);
					
					
					if (tempArg instanceof AccountDAO) {
						//downcast and print Account specific stuff
						AccountDAO theAccount = (AccountDAO) tempArg;
						
						
					}
					
				}
	}
	

}
