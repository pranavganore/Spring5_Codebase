package com.pbg.springdemo.library;

public class CricketCoach implements Coach {

	
	@Override
	public String getDailyWorkout() {
		return "Cricket Coach : Pracktice Fast bowling for 20 min";
	}

	
	/*	-------------Dependency Injection Demo , Via - Setters-------------	*/

	// Define a private field for the dependency to be injected
	private FortuneService fortuneService;
	
	// Create a no-arg Constructor
	public CricketCoach() {
		// Just for Diagnostic purposes
		// System.out.println("Cricket Coach : Inside no-arg Constructor");
	}
	
	// Generate a Setter method
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;	
		
		// Just for Diagnostic purposes
		// System.out.println("Cricket Coach : Inside Setter method - setFortuneService");
	}
	@Override
	public String getDailyFortune() {
		return "Cricket Coach : " + fortuneService.getFortune();
	}

	
	/*	-------------Injecting Literal Values-------------	*/
	
	// Add new fields you wish to use for injecting values literraly
	private String emailID;
	private String teamName;

	//Create Setter methods for these fields
	public void setEmailID(String emailID) {
		this.emailID = emailID;
		// Just for Diagnostic purposes
		System.out.println("Cricket Coach : Inside setter method - setEmailID");
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
		// Just for Diagnostic purposes
		System.out.println("Cricket Coach : Inside setter method - setteamName");
	}
	
	// Creating getter methods for diagnostic display purposes
	public String getTeamName() {
		return teamName;
	}
	
	public String getEmailID() {
		return emailID;
	}
	
	/*	-------------Injecting values using a Properties file-------------	*/
	
	// Add new fields you wish to use for injecting values literraly
	private String coachName;
	private String stateName;

	//Create Setter methods for these fields

	public void setCoachName(String coachName) {
		this.coachName = coachName;
		// Just for Diagnostic purposes
		System.out.println("Cricket Coach : Inside setter method - setCoachName");
	}
	
	public void setStateName(String stateName) {
		this.stateName = stateName;
		// Just for Diagnostic purposes
		System.out.println("Cricket Coach : Inside setter method - setStateName");
	}
	
	public String getStateName() {
		return stateName;
	}
	public String getCoachName() {
		return coachName;
	}




	
}
