package com.pbg.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pbg.springdemo.library.Coach;

public class AnnotationsBeanScope_DemoApp {

	public static void main(String[] args) {
		// Read spring configuration file
		ClassPathXmlApplicationContext context= 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Get the bean from the spring container
		Coach theCoach = context.getBean("thatSillyTennisCoach", Coach.class);
		Coach alphaCoach = context.getBean("thatSillyTennisCoach", Coach.class);
		
		// CCheckif they are same beans
		boolean result = (theCoach == alphaCoach);
		
		// Print our the results
		System.out.println("\nIs pointing to the same Object ? - > " + result);

		System.out.println("\nMemory loaction for theCoach -> " + theCoach);
		
		System.out.println("\nMemory loaction for alphaCoach -> " + alphaCoach);
		
		
		
		// Close the context
		context.close();


	}

}
