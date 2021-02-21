package com.pbg.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pbg.springdemo.library.Coach;

/*	-------------Annotations Demo App-------------	*/

/*	We have used the annotation @Component in class TennisCoach
 * 
 *  We also use the annotation @Autowired for dependency injection there
 * */
public class Annotation_DemoApp {

	public static void main(String[] args) {
		
		// Read spring configuration file
		ClassPathXmlApplicationContext context= 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Get the bean from the spring container
		Coach theCoach = context.getBean("thatSillyTennisCoach", Coach.class);
		
		// Call a method on the bean
		// Demonstrates Inversion Control Using Annotations
		System.out.println(theCoach.getDailyWorkout());
		
		// Call extra method getDailyFortune
		/*
		 * Demonstrates successful inversion control with dependency injection using annotations 
		 * - Constructor Dependency Injection using Annotation (@Autowired)
		 * - Setter Dependency Injection using Annotation (@Autowired)
		 * - Method Dependency Injection using Annotation (@Autowired)
		 * - Field Dependency Injection using Annotation (@Autowired)
		 * Also demonstrates the @Qualifier annotation
		 */
		System.out.println(theCoach.getDailyFortune());
		
		
		
		// Close the context
		context.close();

	}

}
