package com.pbg.springdemo.library;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {

	
	private FortuneService fortuneService;
	
	// demonstrates referencing the values from the properties file 'sport.properties' 
		// using direct field injection method
	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String team;
	
	public SwimCoach(FortuneService FS) {
		fortuneService = FS;
	}
	
	
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Swim 1000 mtrs as a warmup";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}


	// getter methods for email and team
	public String getEmail() {
		return email;
	}
	public String getTeam() {
		return team;
	}

	
}


/*
 * Process of injecting Values from properties file:
 * 
 * 	1.	Create properties file (ex. sport.properties)
 * 	2.	Load properties file in Spring Configuration
 * 	3.	Reference values from properties file (by direct field injections) <- done here lines 10-15
 * */
