package com.pbg.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pbg.springdemo.library.Coach;

/*	-------------Spring Bean LifeCycle Demonstration App-------------	*/


public class BeanLifeCycle_DemoApp {

	public static void main(String[] args) {
		
		// Load the spring configuration file
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext ("beanLifeCycle-applicationContext.xml");
				
				
		// Retrieve Bean from Spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);

		
		System.out.println(theCoach.getDailyWorkout());
		
		
		//close the context
		context.close();
		
	}

}

/* 	Remember - There is a subtle point you need to be aware about the "Prototype" scoped beans.
 *		For "Prototype" scoped beans, Spring does not call the destroy method. Gasp!!
 *		In contrast to the other scopes, Spring does not manage the complete lifecycle of a 
 *		prototype bean. : The container instantiates, configures, and otherwise assembles a prototype
 *		object, and hands it to the client, with no further record of that prototype instance.
 *
 *		Thus, although initialization lifecycle callback methods are called o all objects regardless
 *		of scope, in case of prototypes, configured destruction lifecycle callbacks are not called.
 *			The client code must cleanup prototype-scoped objects and release expensive resources
 *		that the prototype bean(s) are holding.
 *
 */


/*
 * There are 3 ways to configure a Spring Container :
 * 	1. Full XML Configuration		<<-- We have seen this type here in this project 'spring-demo-one'
 * 	2. XML Component scan (using annotations)
 * 	3. Java Configuration Class
 * */