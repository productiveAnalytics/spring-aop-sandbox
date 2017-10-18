package com.productiveAnalytics.springaopsandbox;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.productiveAnalytics.springaopsandbox.exceptions.MyException;
import com.productiveAnalytics.springaopsandbox.services.Business1;
import com.productiveAnalytics.springaopsandbox.services.Business2;

@SpringBootApplication
public class SpringAopSandboxApplication
			 implements CommandLineRunner
{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Business1 business1;
	
	@Autowired
	private Business2 business2;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringAopSandboxApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		logger.info("Business1 calculates SQR = {}", business1.calculateSquare());
		try {
			int num = business1.trySomething();
			logger.info("Business1 tries something, and returns int : {}", num);
		} catch (MyException myEx) {
			logger.error("ERROR: {}", myEx.getMessage());
		}
		business1.performComplexOperation();
		
		/* --- */
		
		logger.info("Business2 flips coin : {}", business2.tossCoin());
		logger.info("Business2 returns date/time : {}", business2.formatCurrentDate());
		try {
			boolean bool = business2.trySomething();
			logger.info("Business2 tries something, and returns booean : {}", bool);
		} catch (MyException myEx) {
			logger.error("ERROR: {}", myEx.getMessage());
		}
		business2.performComplexOperation();
	}
}
