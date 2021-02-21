package com.pbg.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pbg.springdemo.library.Coach;

public class HelloSpringApp {

	public static void main(String[] args) {

		// Load the spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Retrieve bean from spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		// Call methods on bean
		System.out.println(theCoach.getDailyWorkout());
		
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