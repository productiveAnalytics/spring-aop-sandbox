package com.productiveAnalytics.springaopsandbox.model;

import java.util.Random;

import org.springframework.stereotype.Repository;

@Repository
public class Dao2 {

	public boolean retrieveBoolean() {
		return new Random().nextBoolean();
	}
}
