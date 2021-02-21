package com.pbg.springdemo.library.excercise;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.pbg.springdemo.library.Coach;

public class Excercise_App {

	public static void main(String[] args) {
		
		// Load the spring configuration 
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(myJavaConfigClass.class);
		
		// Create the bean
		ExcerCoach theECoach = context.getBean(ExcerCoach.class);
		
		// Call the methods
		System.out.println(theECoach.getDailyExcercise());
		System.out.println(theECoach.getFortune());
		
		//close the context
		context.close();
		
	}

}
