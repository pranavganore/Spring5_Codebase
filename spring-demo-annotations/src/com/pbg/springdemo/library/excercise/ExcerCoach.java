package com.pbg.springdemo.library.excercise;

public class ExcerCoach {


	private MainFortuneServiceClass fortuneService;
	
	public ExcerCoach(MainFortuneServiceClass MFS) {
		fortuneService = MFS;
	}

	public String getDailyExcercise() {
		return "Do 10 suryanamaskars daily!";
	}
	
	public String getFortune() {
		return fortuneService.myFortuneService();
	}
		

}
