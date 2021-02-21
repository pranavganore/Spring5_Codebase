package com.pbg.springdemo.mvc.customValidation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)	//Helper class that has business rules / validation logic
@Target( { ElementType.METHOD, ElementType.FIELD } )	//specifies that the annotation can be applied to a method or a field
@Retention(RetentionPolicy.RUNTIME)		// Retains the annotation in class file(bytecode) to make it available during RUNTIME
public @interface CourseCode {		//using @interface we can create a custom annotation
	
	//	Define default course code
	public String value() default "LUV";
	
	//	Define default error message
	public String message() default "must start with 'LUV'";
	
	// 	Define default groups
	public Class<?>[] groups() default {};
	
	//	Define default payloads
	public Class<? extends Payload>[] payload() default {};
}

