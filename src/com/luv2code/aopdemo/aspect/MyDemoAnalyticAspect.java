package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyDemoAnalyticAspect {
	
	//this is where we add all of our related advices for logging
	

	

	@Before("com.luv2code.aopdemo.aspect.AopExpessions.finalpointcut()")
	public void performApiAnalytics() {
		
		System.out.println("\n===================>>>>>>>  Executing @ performApiAnalytics");
	}	 

}
