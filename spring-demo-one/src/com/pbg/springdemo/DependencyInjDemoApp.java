package com.pbg.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pbg.springdemo.library.Coach;
import com.pbg.springdemo.library.CricketCoach;
/*	-------------Dependency Injection Demo App-------------	*/
/*	Dependency Injection Via
 * 		- Constructors
 * 		- Setters
 * 			~ Injecting literal values 
 * 			~ Injecting values from a Property file
 * 	*/
public class DependencyInjDemoApp {

	public static void main(String[] args) {
		
		// Load the Spring Configuration File
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext ("applicationContext.xml");
		
		// Retrieve the Spring Bean from the Spring Container
		
		// for Constructor Dependency Injection
		Coach theCoach = context.getBean("myCoach", Coach.class);	
		
		// for Setter Dependency Injection - here we are using Object of class CricketCoach instead
			// of Coach class like above, because we are injecting values to fields of 
			// CricketCoach class and those fields are not a part of Coach class
		CricketCoach CriCoach = context.getBean("myCricketCoach", CricketCoach.class);
		
		// Call the methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		// Call the methods for fortune service 
		// (demonstrates successful dependency injection via Constructor)
		System.out.println(theCoach.getDailyFortune());
		
		// Call more methods for fortune service 
		// (demonstrates successful dependency injection via Setter)
		System.out.println(CriCoach.getDailyWorkout());
		System.out.println(CriCoach.getDailyFortune());
		// here we can also use theCoach object (but to specifically keep the context to Cricket
			//coach class we have used object of CricketCoach here)
		
		// Call more methods for fortune service 
		// (demonstrates successful literal values injection via Setter)
		System.out.println(CriCoach.getEmailID());
		System.out.println(CriCoach.getTeamName());
		
		// Call more methods for fortune service 
		// (demonstrates successful values injection using a properties file via Setter)
		System.out.println(CriCoach.getStateName());
		System.out.println(CriCoach.getCoachName());
		
		// Close the context
		context.close();


	}

}



/*
 * There are 3 ways to configure a Spring Container :
 * 	1. Full XML Configuration		<<-- We have seen this type here in this project 'spring-demo-one'
 * 	2. XML Component scan (using annotations)
 * 	3. Java Configuration Class
 * */