package com.pbg.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pbg.springdemo.library.Coach;

/*	----Demo App for Configuring Spring container using a Java Configuration Class----	*/

/*
 * There are 3 ways to configure a Spring Container :
 * 	1. Full XML Configuration
 * 	2. XML Component scan (using annotations)
 * 	3. Java Configuration Class <<-- We are seeing this type here in this class
 * 
 * Here instead of configuring spring container using XML,
 * 	we directly configure the spring container with JAVA code
 * 
 * The process to do so is given at the end of the class
 * */


// Note : Uncomment line 13 in class SportConfig.java for this app to work.

public class JavaConfig_DemoApp {

	public static void main(String[] args) {
		
		// Read spring configuration Java Class
		AnnotationConfigApplicationContext context= 
				new AnnotationConfigApplicationContext(SportConfig.class);
		
		// Get the bean from the spring container
		Coach theCoach = context.getBean("thatSillyTennisCoach", Coach.class);
		
		// Call a method on the bean
		// Demonstrates Inversion Control Using Annotations
		System.out.println(theCoach.getDailyWorkout());
		
		// Call extra method getDailyFortune
		System.out.println(theCoach.getDailyFortune());
		
		
		
		// Close the context
		context.close();

	}

}

/*
 * Process of Spring configuration with Java code and no xml files
 * 
 * 	1.	Create a Java Class and annotate it as @Configuration
 * 	2.	Add component scanning support @ComponentScan (optional)
 * 	3.	Read Spring Java configuration class
 * 	4.	Retrieve bean from Spring container
 * */

/*	We have used the annotation @Configuration in class 'SportConfig' in order to specify that 
 * 		it is a java configuration class.
 * 	And we use the annotation ComponentScan("com.pbg.springdemo") in our java config class 'SportConfig'
 * 		in order to specify the package where in spring should scan for the components.
 * 	
 * 	Also, We have used the annotation @Component in class TennisCoach
 * 
 *  We also use the annotation @Autowired for dependency injection there
 * */



/*
 * Process of Spring configuration with Java code and no xml files
 * 
 * 	1.	Create a Java Class and annotate it as @Configuration
 * 	2.	Add component scanning support @ComponentScan (optional)
 * 	3.	Read Spring Java configuration class
 * 	4.	Retrieve bean from Spring container
 * */
