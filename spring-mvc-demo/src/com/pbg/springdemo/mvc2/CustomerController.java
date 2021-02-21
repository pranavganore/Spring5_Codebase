package com.pbg.springdemo.mvc2;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


/* ----- Spring MVC - Form Validation (applying built in validation rules) ----- */

/* ----- Adding preprocessor code with @InitBinder for advanced validation ----- */

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		
		theModel.addAttribute("customer", new Customer());	//	(name, value)
		
		return "customer-form";
	}
	
	
	//Step 3: Perform Validation in controller class
	
	@RequestMapping("/processForm")
	public String processForm(	//Tell Spring to validate the customer object
			@Valid 		//it will validate the attribute specified in the annotation below(See Note 1 below v imp)
			@ModelAttribute("customer") Customer theCustomer,
			BindingResult theBindingResult) {	// Spring stores the results of validation in BindingResult Object
		
		//adding some prints for debug and personal info
		System.out.println("Last Name : |" + theCustomer.getLastName() + "|");
		System.out.println("Binding result" + theBindingResult + " \n\n\n\n");
		
		
		//	Handle the validation result the way you want
		//	here I am returning the user back to the Customer form if there are any errors
				//	if no errors show the success page : customer-confirmation
		if (theBindingResult.hasErrors()) {
			return "customer-form";
		}else {
			return "customer-confirmation"; 
		}
		
	}
	
	
	
	
	/*---- Add an InitBinder (... to convert the trim input strings) ----*/
	
	@InitBinder
	public void initBinderFunction(WebDataBinder dataBinder) {
		//	remove trailing and leading white spaces
		//	resolve issue for our validation
		StringTrimmerEditor STE = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, STE);
		
	}	//	@InitBinder annotation works as a preprocessor
	//	It will pre-process each web request to our controller
	//	Method annotated with @InitBinder is executed
	// this method will be called for our every web req coming on to our controller
}


/* Note 1:
 * Special Note about BindingResult Parameter Order:
 * 	When performing Spring MVC validation, the location of the BindingResult parameter is very important. 
 * 	In the method signature, the BindingResult parameter must appear immediately after the model attribute. 
 * 	
 * 	If you place it in any other location, Spring MVC validation will not work as desired. In fact, your 
 * 	validation rules will be ignored.
 * 
 * 
 * 		@RequestMapping("/processForm")
 * 		public String processForm(
 * 			@Valid @ModelAttribute("customer") Customer theCustomer,
 * 					BindingResult theBindingResult) {
 * 					...            
 * 			}
 * 
 * 	Here is the relevant section from the Spring Reference Manual
 * 	---
 * 		Defining @RequestMapping methods
 * 		@RequestMapping handler methods have a flexible signature and can choose from a range of supported 
 * 			controller method arguments and return values....
 * 		
 * 		The Errors or BindingResult parameters have to follow the model object that is being bound 
 * 		immediately ...
 * 		
 * 		Source: https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#mvc-ann-methods
 * 
 */
