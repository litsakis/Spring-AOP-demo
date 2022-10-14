package com.luv2code.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	@Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")	
	public Object arroundGetFortune(
			ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		// print out method we are advising on
		String method = theProceedingJoinPoint.getSignature().toShortString();
		myLogger.info("\n==========================>>>Executing  @Around on method: " + method);
		//get begin timestamp
		long begin = System.currentTimeMillis();
		//new, let's execute the method
		Object result = theProceedingJoinPoint.proceed();
		// get end timestamp
		long stop = System.currentTimeMillis();

		//compute
		myLogger.info("Duration= "+ (stop-begin)/1000.0 +" second");
		
		return result;
	}
	
	
	
	
	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))"	
			)
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint){
		myLogger.info("\\n===================>>>>>>>  Executing @after()");
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n==========================>>>Executing  " + method);
		
		
		
	}
	
	
	
	
	
	@AfterThrowing(
		pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
		throwing="theExc"
			
			)
	public void afterThrowingFindAccountAdvice(JoinPoint theJoinPoint, Throwable theExc) {
		//
		myLogger.info("\\n===================>>>>>>>  Executing @afterThrowingFindAccountAdvice()");
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n==========================>>> Th e exception is  " + theExc);
	}
	@AfterReturning(
			pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result"
			)
	public void afterReturningFindAccountsAdvice(
		JoinPoint theJoinPoint, List<Account> result) {
		
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n==========================>>> Executing @AfterReturning on method: " + method);
		//print out the results of the methods call
		myLogger.info("\n==========================>>> result is: : " + result);

		
		
	}
	
	@Before("com.luv2code.aopdemo.aspect.AopExpessions.finalpointcut()")
	public void beforeAddAcoountAdvice(JoinPoint theJoinPoint) {
		
		myLogger.info("\n===================>>>>>>>  Executing @beforeAddAcoountAdvice()");
		
		
		
		//display the method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		
		myLogger.info("Method: "+methodSig);
		
		//display the method arguments
		//get args
		
		Object[] args= theJoinPoint.getArgs();

		//loop thru arg
				
				for (Object tempArg : args) {
					myLogger.info(tempArg.toString());
					
					
					if (tempArg instanceof AccountDAO) {
						//downcast and print Account specific stuff
						AccountDAO theAccount = (AccountDAO) tempArg;
						
						
					}
					
				}
	}
	

}
