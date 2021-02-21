package com.pbg.springdemo.library;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class HappyFortuneService implements FortuneService {

	private List<String> fortunes = Arrays.asList("You will get a Job!","You will have a good Day","It's going to be a bad day");
	
	
	@Override
	public String getFortune() {
		
		Random rand = new Random();
	    
		return (fortunes.get(rand.nextInt(fortunes.size())));
		// simple same fortune for everyone
		//return "You are soon gonna get a Job !";
		
		
	}

}
