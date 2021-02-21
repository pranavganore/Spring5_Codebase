package com.pbg.springdemo.mvc1;

import java.util.LinkedHashMap;


/* ------ Spring MVC - Form Tags & Data Binding ------ */


public class Student {

	private String firstName;
	private String lastName;
	
	private String country_residency;
	private String country_citizenship;
	
	private String favLanguage;
	
	private String[] OS;
	
	private LinkedHashMap<String,String> res_countryOptions;
	
	public Student() {
	
		//	Populate country options : used ISO country code
		res_countryOptions = new LinkedHashMap<>();
		
		res_countryOptions.put("BR", "Brazil");
		res_countryOptions.put("IN", "India");
		res_countryOptions.put("US", "America");
		res_countryOptions.put("FR", "France");
		res_countryOptions.put("GR", "Germany");
		
	}
	
	
	
	// Getters & Setters

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry_residency() {
		return country_residency;
	}

	public void setCountry_residency(String country_residency) {
		this.country_residency = country_residency;
	}

	public String getCountry_citizenship() {
		return country_citizenship;
	}

	public void setCountry_citizenship(String country_citizenship) {
		this.country_citizenship = country_citizenship;
	}

	public LinkedHashMap<String, String> getres_countryOptions() {
		return res_countryOptions;
	}

	public String getFavLanguage() {
		return favLanguage;
	}

	public void setFavLanguage(String favLanguage) {
		this.favLanguage = favLanguage;
	}

	public String[] getOS() {
		return OS;
	}

	public void setOS(String[] oS) {
		OS = oS;
	}


	
	
	
}
