package com.pbg.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pbg.springdemo.library.Coach;
import com.pbg.springdemo.library.SwimCoach;

/*	----Demo App for defining spring Beans using Java code while Configuring Spring 
 * 					container using a Java Configuration Class----	*/

public class SwimJavaConfig_DemoApp {

	public static void main(String[] args) {
		
		// Read spring configuration Java Class
		AnnotationConfigApplicationContext context= 
				new AnnotationConfigApplicationContext(SportConfig.class);
		
		// Get the bean from the spring container
		Coach theCoach = context.getBean("swimCoach", Coach.class);
		
		// Call a method on the bean
		// Demonstrates Inversion Control Using Annotations
		System.out.println(theCoach.getDailyWorkout());
		
		// Call extra method getDailyFortune
		System.out.println(theCoach.getDailyFortune());
		
		
		// demonstrate the field injection from properties file
		// Get the bean from the spring container
		SwimCoach theSwimCoach = context.getBean("swimCoach", SwimCoach.class);
		
		// Call the getter methods on the fields injected from the properties file to verify
		System.out.println("SwimCoach : email : " + theSwimCoach.getEmail());
		System.out.println("SwimCoach : team : " + theSwimCoach.getTeam());
		
		// Close the context
		context.close();

	}

}

/*
 * Process of Spring configuration with Java code and no xml files :
 * 
 * 	1.	Create a Java Class and annotate it as @Configuration
 * 	2.	Add component scanning support @ComponentScan (optional)
 * 	3.	Read Spring Java configuration class
 * 	4.	Retrieve bean from Spring container
 * */
/*
 * Process of Defining Spring Beans with Java code (without any XML) :
 * 
 * 	1.	Define Method to expose bean
 *	2.	Inject Bean dependencies
 *	3.	Read Spring Java Configuration Class
 *	4.	Retrieve bean from the spring container
 */
/*
 * Process of injecting Values from properties file:
 * 
 * 	1.	Create properties file (ex. sport.properties)
 * 	2.	Load properties file in Spring Configuration
 * 	3.	Reference values from properties file (by direct field injections)
 * */
