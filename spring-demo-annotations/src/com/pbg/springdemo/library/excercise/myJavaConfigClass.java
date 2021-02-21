package com.pbg.springdemo.library.excercise;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class myJavaConfigClass {

	// Define Beans here
	
	//define a bean for happy fortune service
	@Bean
	public MainFortuneServiceClass mainFortuneService() {
		return new MainFortuneServiceClass();
	}
	
	//define a bean for exercise coach
	@Bean
	public ExcerCoach Ecoach() {
		return new ExcerCoach(mainFortuneService());
	}
	

}
