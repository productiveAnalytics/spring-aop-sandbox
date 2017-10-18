package com.productiveAnalytics.springaopsandbox.model;

import java.util.Random;

import org.springframework.stereotype.Repository;

@Repository
public class Dao1 {

	public int retrieveNumber() {
		return new Random().nextInt(100);
	}
}
