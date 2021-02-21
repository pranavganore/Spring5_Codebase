package com.pbg.springdemo.library;

import org.springframework.stereotype.Component;

/* this class is created to demonstrate @Qualifier annotation 
 * to resolve the dependency resolution 
 */

@Component
public class DBFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		
		return "DB Service Fortune :: Its a ok day!! ";
	}

}
