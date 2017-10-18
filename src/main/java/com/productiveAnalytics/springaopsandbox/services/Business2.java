package com.productiveAnalytics.springaopsandbox.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productiveAnalytics.springaopsandbox.exceptions.MyException;
import com.productiveAnalytics.springaopsandbox.model.Dao2;

@Service
public class Business2
{
	private static DateFormat YYYYMMdd_hhmmss = new SimpleDateFormat("YYYYMMdd hhmmss");
	
	@Autowired
	private Dao2 dao2;
	
	public String formatCurrentDate() {
		return YYYYMMdd_hhmmss.format(new Date());
	}
	
	public String tossCoin() {
		return dao2.retrieveBoolean() ? "Heads" : "Tails";
	}
	
	public boolean trySomething()
					throws MyException
	{
		if (new Date().getTime() % 2 == 0) 
			throw new MyException("Even exception.");
		
		return dao2.retrieveBoolean();
	}
	
	public String performComplexOperation()
	{
		int randomNum = new Random().nextInt(10);
		try {
			Thread.sleep(randomNum * 100);
		} catch (InterruptedException iEx) {
			iEx.printStackTrace();
		}
		return "Str_"+randomNum;
	}
}
