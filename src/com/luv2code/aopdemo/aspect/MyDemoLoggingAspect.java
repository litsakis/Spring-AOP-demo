package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(0)
public class MyDemoLoggingAspect {
	
	//this is where we add all of our related advices for logging
	
	//create a pointcut to getters
	 
	
	@Before("com.luv2code.aopdemo.aspect.AopExpessions.finalpointcut()")
	public void beforeAddAcoountAdvice() {
		
		System.out.println("\n===================>>>>>>>  Executing @beforeAddAcoountAdvice()");
	}
	

}
