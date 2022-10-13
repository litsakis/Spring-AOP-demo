package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpessions {
	//create a pointcut to getters
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
	public void getters() {}
	
	//create a pointcut to setters
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
	public void setters() {}
	//create pointcut to include package and exclude getter and setters
	@Pointcut("forDaoPackage() && !getters() && !setters() ")
	public void finalpointcut() {}
	
 
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	
}
