package com.pbg.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pbg.springdemo.library.Coach;

/*	-------------Demonstrating the Spring Beans Scope-------------	*/
/*	Types of scope are:
 * 		Singleton
 * 		Prototype
 * 		..
 * 		..
 * 		..
 * 	These scopes are defined in a bean declaration in an applicationContext XML file.
 * 	*/


public class BeanScope_DemoApp {

	public static void main(String[] args) {
		
		// Load the spring configuration file
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext ("beanScope-applicationContext.xml");
				
				
		// Retrieve Bean from Spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		
		
		// Check if they are the same beans
		boolean result = (theCoach == alphaCoach);
		
		// Print the results
		System.out.println("\nPointing to the same object ? -> " + result);
		
		System.out.println("\nMemory location of theCoach bean : " + theCoach);
		
		System.out.println("\nMemory location of alphaCoach bean : " + alphaCoach);
		
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
