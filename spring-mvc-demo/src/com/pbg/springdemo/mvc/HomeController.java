package com.pbg.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/* ----- Spring MVC - Building Spring Web Apps ----- */

/* ----- Creating Controllers & Views -----*/

// This is the controller class and we make it so by adding this annotation
@Controller		// It simply says that this is a Spring MVC Controller 
public class HomeController {
	
	@RequestMapping("/")			// We map this controller method to some kind of web request
	public String showPage() {		//	this is a controller method - we can use any method name coz
		return "main-menu";				// thats because an annotation maps a path to a method name.
	}

	// Now spring will find the view page named what is returned above  e.g. main-menu.jsp in this case
		//but it will append prefix and suffix to it , as specified in 'spring-mvc-demo-servlet.xml'

}

/*
 * Creating a Spring Home Controller and View Process:
 * 
 * 	1.	Create the Controller class
 * 	2.	Define Controller method
 * 	3.	Add request mapping to controller method
 * 	4.	Return View name
 * 	5.	Develop view page	- e.g. any .jsp page
 * 
 * */


/*
 * Now this annotation @Controller is inherited from @Component
 * */
 