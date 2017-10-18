package com.productiveAnalytics.springaopsandbox.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class ComplextOperationPointcut 
{
	@Pointcut("execution (* com.productiveAnalytics.springaopsandbox.services..performComplexOperation(..))")
	public void complextOperation() {}
}
