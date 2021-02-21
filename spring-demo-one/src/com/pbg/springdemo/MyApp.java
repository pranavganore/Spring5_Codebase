package com.pbg.springdemo;

import com.pbg.springdemo.library.BaseballCoach;
import com.pbg.springdemo.library.Coach;
import com.pbg.springdemo.library.TrackCoach;

public class MyApp {

	public static void main(String[] args) {
		
		// Create the object
		Coach theCoach = new BaseballCoach();
		
		Coach theTrackCoach = new TrackCoach();
		
		// use the object
		System.out.println(theCoach.getDailyWorkout());
		
		System.out.println(theTrackCoach.getDailyWorkout());

	}

}

/*
 * There are 3 ways to configure a Spring Container :
 * 	1. Full XML Configuration		<<-- We have seen this type here in this project 'spring-demo-one'
 * 	2. XML Component scan (using annotations)
 * 	3. Java Configuration Class
 * */