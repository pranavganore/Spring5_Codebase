package com.pbg.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/* ------ Demonstrating Reading HTML Form Data & Adding data to Spring MODEL------ */

/*----- Demonstrating Binding Request Parameters-----*/

/*----- Demonstrating Controller Level Request Mapping -----*/
@Controller
//@RequestMapping("/hello")			// This is a controller level req mapping (it creates the hierarchy and avoids ambiguity if there exists duplicate request mappings of its sub mappings )
public class HelloWorldClass {

	// Need a controller method to show the initial HTML form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";		// returns JSP view name 
	}
	
	
	//	Need a controller method to process the HTML form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";			// returns JSP view name
	}
	
	
	
	/* ---- Demonstrating process of Adding data to MODEL -----*/
	
	
	// New controller method to read form data & add data to model
	@RequestMapping("/processForm_Ver_2")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		
		// Read the request parameter from the HTML form
		String theName = request.getParameter("studentName");		// This should match the input type name
																		// parameter from the JSP form html
		
		// Do the processing on the data - here convert to Uppercase
		theName = theName.toUpperCase();
		
		// Create the message to be passed
		String result = "Yo ! " + theName;
		
		// Add the message to the model to be passed to the view 
		model.addAttribute("message", result);		//(name,value)	we can access this attribute in JSP page 
														// using this name we specify 
			
		return "helloworld";			// returns JSP View name
	}
	
	
	
	
	/* ---- Demonstrating process of Binding request parameters -----*/
	
	// New controller method to read form data & add data to model
	@RequestMapping("/processForm_Ver_3")
	public String processForm_Ver_3(
			@RequestParam("studentName") String theName, Model model) {		// Binding req params
		
		// Read the request parameter from the HTML form
		//String theName = request.getParameter("studentName");		// this is done by line 60
		
		// Do the processing on the data - here convert to Uppercase
		theName = theName.toUpperCase();
		
		// Create the message to be passed
		String result = "Hi from V3 ! " + theName;
		
		// Add the message to the model to be passed to the view 
		model.addAttribute("message", result);		//(name,value)	we can access this attribute in JSP page 
														// using this name we specify 
			
		return "helloworld";			// returns JSP View name
	}
	
	
	
	
	
}

/*	Note 1:
 * 
 * 	Spring Model : The Model is a container for your application data
 * 
 * 	In your controller , you can put anything in the model
 * 		strings, objects, info from database,etc...
 * 
 * 	And your View page (JSP) can access data from the model
 * 
 */
