package com.productiveAnalytics.springaopsandbox.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productiveAnalytics.springaopsandbox.exceptions.MyException;
import com.productiveAnalytics.springaopsandbox.model.Dao1;

@Service
public class Business1
{
	@Autowired
	private Dao1 dao1;
	
	public int calculateSquare() {
		int n = dao1.retrieveNumber();
		return n * n;
	}
	
	public int trySomething()
			   throws MyException
	{
		if (new Date().getTime() % 2 == 1) 
			throw new MyException("Odd exception.");
		
		return dao1.retrieveNumber();
	}
	
	public Integer performComplexOperation()
	{
		int num = dao1.retrieveNumber();
		try {
			Thread.sleep(num * 100);
		} catch (InterruptedException iEx) {
			iEx.printStackTrace();
		}
		return num;
	}
}
