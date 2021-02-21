package com.pbg.springdemo.mvc2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.pbg.springdemo.mvc.customValidation.CourseCode;


/* ----- Spring MVC - Form Validation (applying built in validation rules) ----- */


public class Customer {

	private String firstName;
	
	//	Step1 : Add a validation rule to customer class
	
	// Adding form validation using inbuilt validation rules
	@NotNull(message="is required!!")				// Makes a field mandatory(*)
	@Size(min=1, message="is a mandatory field")
	private String lastName;

	@NotNull(message="is required!!")				// Makes a field mandatory(*)
	@Min(value=0, message="must be >= 0")
	@Max(value=10, message="must be <=10")
	private Integer freePasses;				// Make sure to use Integer instead of int 
												// in order to @NotNull to work
	

	@Pattern(regexp="^[a-zA-z0-9]{5}",message="Must be 5 characters long")
	private String postalCode;
	

	
	/*	Process to create a custom validation by creating a custom annotation :
	 * 	Step 1.	:Create the custom annotation @CourseCode
	 * 	Step 2.	:Create CourseCodeConstraintValidator - here we put our business logic / validation rules
	 */
	
	@CourseCode(value="LUV", message="must start with 'LUV' ")	// Our custom annotation for validation
	private String courseCode;
	
	
	
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

	public Integer getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	
	
}
