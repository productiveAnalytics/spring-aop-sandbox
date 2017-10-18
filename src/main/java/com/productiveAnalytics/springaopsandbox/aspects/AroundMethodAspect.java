package com.productiveAnalytics.springaopsandbox.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AroundMethodAspect
{
	private static final Logger LOGGER = LoggerFactory.getLogger(AroundMethodAspect.class);
	
//	@Around ("execution (* com.productiveAnalytics.springaopsandbox.services.*.performComplexOperation(..))")
	@Around ("com.productiveAnalytics.springaopsandbox.aspects.ComplextOperationPointcut.complextOperation()")
	public Object logExceutionTime(ProceedingJoinPoint proceedingJoinPoint) 
				  throws Throwable
	{
		long startTime = System.currentTimeMillis();
		
		// continue w/ actual method execution
		Object retVal = null;
		retVal = proceedingJoinPoint.proceed();
		
		long endTime = System.currentTimeMillis();
		
		LOGGER.info("***Time taken by Method: {} is {} ms",  proceedingJoinPoint.getSignature().getName(), (endTime - startTime));
		
		return retVal;
	}
}
