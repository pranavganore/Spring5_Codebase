package com.pbg.springdemo.library;

public class TrackCoach implements Coach {

	@Override
	public String getDailyWorkout() {

		return "Track Coach : Run a hard 5k";
	}

	
	// Dependency Injection Demo , Via - Constructor 
	// Define a private field for the dependency to be injected
	private FortuneService fortuneService;
	
	// Define a constructor for "Constructor Dependency Injection"
	public TrackCoach (FortuneService FS) {
		fortuneService = FS;
	} // this makes our class ready to accept dependency injection via a constructor from the spring framework

	@Override
	public String getDailyFortune() {
		// Use fortuneService to get a fortune
		return "Track Coach : " + fortuneService.getFortune();
	}

	
	
	// Required for MyApp.java - As we have created Parameterized Constructor above,
			//Java wont create a default constructor in that case, hence we have to create it
	public TrackCoach() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	// adding an init method		//it should be a no-arg method
	public void doMyStartupStuff() {
		System.out.println("Performing my startup stuff using init method");
	}

	// adding a destroy method		//it should be a no-arg method
	public void doMyCleanupStuff() {
		System.out.println("Performing my cleanup stuff using destroy method");
	}
}
