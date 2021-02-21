package com.pbg.springdemo.library;

import org.springframework.stereotype.Component;

/* this class is created to demonstrate @Qualifier annotation 
 * to resolve the dependency resolution 
 */

@Component
public class RESTFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		
		return "REST Service Fortune :: Its a great day!! ";
	}

}
