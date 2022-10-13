package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.dao.AccountDAO;

@Aspect
@Component
@Order(0)
public class MyDemoLoggingAspect {
	
	//this is where we add all of our related advices for logging
	
	//create a pointcut to getters
	 
	
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
