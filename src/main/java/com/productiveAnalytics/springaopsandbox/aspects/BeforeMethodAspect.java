package com.productiveAnalytics.springaopsandbox.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BeforeMethodAspect
{
	private static final Logger LOGGER = LoggerFactory.getLogger(BeforeMethodAspect.class);
	
	// execution (returnType PACKAGE.CLASSNAME.METHODNAME(..))
	// e.g. for intercepting every method in every class inside PACAKGE use : execution (* PACKAGE.*.*(..))
	@Before ("execution (* com.productiveAnalytics.springaopsandbox.services.Business1.*(..)) || execution (* com.productiveAnalytics.springaopsandbox.services..tossCoin(..))")
	public void doBeforeMethod(JoinPoint joinPoint) {
		// Advice
		LOGGER.info("Before invoking method: {}", joinPoint);
	}
}
