package com.pbg.springdemo.library;

public interface Coach {
	
	// Add a service for Inversion of Control
	public String getDailyWorkout();
	
	// Add another service - for Dependency Injection Demo
	public String getDailyFortune();

}
