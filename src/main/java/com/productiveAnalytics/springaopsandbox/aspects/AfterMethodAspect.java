package com.productiveAnalytics.springaopsandbox.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AfterMethodAspect
{
	private static final Logger LOGGER = LoggerFactory.getLogger(AfterMethodAspect.class);
	
	@AfterReturning (value="execution (* com.productiveAnalytics.springaopsandbox.services.Business2.*(..))"
					,returning="returnedObj")
	public void doAfterMethod(JoinPoint joinPoint
							 ,Object returnedObj)
	{
		LOGGER.info("After execution method: {} returns value = {}", joinPoint, returnedObj);
	}
	
	@AfterThrowing (value="execution (* com.productiveAnalytics.springaopsandbox.services.*.trySomething(..))"
			 	   ,throwing="myExcp")
	public void doAfterException (JoinPoint joinPoint, Exception myExcp)
	{
		LOGGER.info("method: {} threw Exception: {}", joinPoint, myExcp.getMessage());
	}
}
