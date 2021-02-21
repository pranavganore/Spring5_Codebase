package com.pbg.springdemo.library;

public class BaseballCoach implements Coach{
	
	@Override
	public String getDailyWorkout() {
		return "Baseball Coach : Spend 30 minutes on batting practice";
	}



	// Dependency Injection Demo , Via - Constructor 
	// Define a private field for the dependency to be injected
	private FortuneService fortuneService;
	
	// Define a constructor for "Constructor Dependency Injection"
	public BaseballCoach (FortuneService FS) {
		fortuneService = FS;
	} // this makes our class ready to accept dependency injection via a constructor from the spring framework

	@Override
	public String getDailyFortune() {
		// Use fortuneService to get a fortune
		return "Baseball Coach : " + fortuneService.getFortune();
	}
	
	
	
	
	// Required for MyApp.java - As we have created Parameterized Constructor above,
		//Java wont create a default constructor in that case, hence we have to create it
	public BaseballCoach() {
		// TODO Auto-generated constructor stub
	}
	
	
}
