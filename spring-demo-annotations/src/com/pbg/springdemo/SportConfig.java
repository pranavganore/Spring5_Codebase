package com.pbg.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.pbg.springdemo.library.Coach;
import com.pbg.springdemo.library.FortuneService;
import com.pbg.springdemo.library.SadFortuneService;
import com.pbg.springdemo.library.SwimCoach;

/* -----Java Configuration Class for Spring Configuration----- */

@Configuration
//@ComponentScan("com.pbg.springdemo") // uncomment this line to see the working of JavaConfig_DemoApp
	//whereas comment this line 13 so as to make the SwimJavaConfig_DemoApp to work
@PropertySource("classpath:sport.properties")	// this annotation is used to load properties file 
	// by specifying its path for the spring configuration. refer notes below
public class SportConfig {
	
	// Define a Bean for our sad fortune service
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	
	// Define a bean for our swim coach AND inject dependency
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}

}

/*
 * There are 3 ways to configure a Spring Container :
 * 	1. Full XML Configuration
 * 	2. XML Component scan (using annotations)
 * 	3. Java Configuration Class <<-- We are seeing this type here in this class
 * */

/*	We have used the annotation @Configuration above in order to specify that 
 * 		it is a java configuration class.
 * 	And we use the annotation ComponentScan("com.pbg.springdemo") above in order to specify 
 * 		the package where in spring should scan for the components.
 */

/*
 * Process of Spring configuration with Java code and no xml files :
 * 
 * 	1.	Create a Java Class and annotate it as @Configuration
 * 	2.	Add component scanning support @ComponentScan (optional)
 * 	3.	Read Spring Java configuration class
 * 	4.	Retrieve bean from Spring container
 * */
/*
 * Process of injecting Values from properties file:
 * 
 * 	1.	Create properties file (ex. sport.properties)
 * 	2.	Load properties file in Spring Configuration		<- Done here on line 18
 * 	3.	Reference values from properties file (by direct field injections)
 * */
