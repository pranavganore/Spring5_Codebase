package com.pbg.springdemo.library;

import org.springframework.stereotype.Component;

/*--- for dependency Injection using annotations Demo ---**/

@Component
public class HappyFortuneClass implements FortuneService {

	@Override
	public String getFortune() {
		
		return "Today is your Lucky Day!!";
	}

}
