package com.pbg.springdemo.mvc1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Map;


/* ------ Spring MVC - Form Tags & Data Binding ------ */

@Controller
@RequestMapping("/student")		/*----- Demonstrates Controller Level Request Mapping -----*/
public class StudentController {

	@Value("#{countryOptions}")
	private Map<String,String> countryOptions;
	
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		
		// Create a student object
		Student theStudent = new Student();
		
		// Add student object to model
		theModel.addAttribute("student",theStudent);	// the name specified here should be used in the form:
															// tag in the html attribute
		
		//	Add the countryOptions to the model (part of demonstrating getting them from properties file )
		theModel.addAttribute("theCountryOptions", countryOptions);
		
		
		return "student-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {
		
		// log input data
		System.out.println("theStudent: " + theStudent.getFirstName() + " " + theStudent.getLastName() +
				"\nCountry Of Residence   : " + theStudent.getCountry_residency() + 
				"\nCountry of Citizenship : " + theStudent.getCountry_citizenship() + 
				"\nFavorite Language      : " + theStudent.getFavLanguage() + 
				"\nOperating System       : " + theStudent.getOS()
				);
		return "student-confirmation";
	}
	
	
	
}
