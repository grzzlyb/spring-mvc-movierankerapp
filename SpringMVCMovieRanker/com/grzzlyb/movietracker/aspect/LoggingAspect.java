package com.grzzlyb.movietracker.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	@Pointcut("execution(* com.grzzlyb.movietracker.controller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* com.grzzlyb.movietracker.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.grzzlyb.movietracker.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}
	
	@Before("forAppFlow()")
	public void before(JoinPoint joinPoint) {
		
		String theMethod = joinPoint.getSignature().toShortString();
		myLogger.info("====> in @Before: calling method: " + theMethod);
		
		Object[] args = joinPoint.getArgs();
		
		for(Object tempArg: args) {
			myLogger.info("====> argument: " + tempArg);
		}
	}
	
	@AfterReturning(
			pointcut="forAppFlow()",
			returning="theResult")
	public void afterRunning(JoinPoint joinPoint, Object theResult) {
		
		String theMethod = joinPoint.getSignature().toShortString();
		myLogger.info("====> in @AfterReturning: from method: " + theMethod);
		
		myLogger.info("====> result: " + theResult);
	}
	
}
