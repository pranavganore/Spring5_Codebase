package com.pbg.springdemo.library;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/*	------ Java Annotations - Inversion of Control & Dependency Injection ------	*/


// Annotated components that will be auto-registered as Spring beans with bean id specified in ("")
@Component("thatSillyTennisCoach")		//Not necessary to define the bean ID, refer Note 1 below
@Scope("singleton")		// Scope by annotation - Not necessary to define (by default singleton scope)
public class TennisCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
		
	}

	
//	private FortuneService fortuneService;
	
	/* -- Java Annotation for Dependency Injections -- */
	// Using this annotation the Spring config will know that this is a dependency and 
			//the object factory will handle it .
	// + Constructor Dependency Injection using annotations. // see note 2
/*	@Autowired				//comment lines 33 to 52 to make this work
	public TennisCoach(FortuneService FS) {
		fortuneService = FS;
	}	
*/	
	
/*	
	//	+ Setter Dependency Injection using annotations (comment lines 26-29 for this to work)
	//	Create a setter and add an annotation to inject/resolve it as a dependency
	@Autowired
	public void setFortuneService(FortuneService FS) {
		fortuneService = FS;
		System.out.println(" Tennis Coach : Inside Setter method - setFortuneService ");
	}
	

*/
	
	
	//	* Method Dependency Injection using annotations (comment lines 26-42 for this to work)
	//	Create any method and add an annotation to inject/resolve it as a dependency
/*	@Autowired
	public void myCustomMethod(FortuneService FS) {
		fortuneService = FS;
		System.out.println(" Tennis Coach : Inside my method - myCustomMethod ");
	}
*/	
	
	// + Field Dependency Injection using annotations (Accomplished by using Java Reflection)
		// This injects dependencies by setting field values on your class directly (even private
			// fields).
	// Comment line 20 to 52 in order for this to work
	// Just add annotation directly to the field and no need to use its setter , spring takes
		// case of this in the background.
/*	@Autowired
	private FortuneService fortuneService;
*/	
	
	// $ Demonstrating the use of @Qualifier annotation
	// Make sure you comment lines 20-63 for this to work
	/*
	 * Now, when we have multiple Services using same Interface, then the spring gets confused
	 * 	while deciding which dependency to use to satisfy the requirement (ambiguity)
	 * Thus to resolve this ambiguity, when there exists multiple beans of same type, 
	 * 	we use @Qualifier("specific Bean ID") to resolve it.
	 * 
	 * If not used it will throw 'NoUniqueBeanDefinitionException', which means it expects single
	 * 	matching bean but it found multiple matching beans
	 */
	@Autowired
	@Qualifier("RESTFortuneService")
	private FortuneService fortuneService;
	
	// We can also inject properties file using java annotations,
	// for details see Section 8 : Slide 74 (Chad Darby UDEMY)
	
	
	//Default Constructor just for diagnostic printing purposes
	public TennisCoach() {
		System.out.println(" Tennis Coach : Inside Default Constructor. ");
	}
	
	
	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();
	}

	// Initialization and Destruction Activities using annotations (Also refer to Note 4 & 5 below)	
	@PostConstruct
	public void doMyStuff_AtInit() {
		System.out.println("\n @PostCOnstruct : Initializing Activities!!\n");
	}
	
	@PreDestroy
	public void doMyStuff_AtEnd() {
		System.out.println("\n @PreDestroy : Cleanup Activities!!\n");
	}

	/*
	 * HEADS UP - FOR JAVA 9, 10 and 11 USERS - @PostConstruct and @PreDestroy
	 * 	If you are using Java 9 or higher, then you will encounter an error when using 
	 * 	@PostConstruct and @PreDestroy in your code. 
	 * 
	 * These are the steps to resolve it.
	 * Error:
	 * Eclipse is unable to import @PostConstruct or @PreDestroy
	 * This happens because of Java 9 and higher. 
	 * When using Java 9 and higher, javax.annotation has been removed from its default classpath.
	 * That's why we Eclipse can't find it.
	 * 
	 * To see the fix - refer to Note 4 below
	 */
	
}

/* 
 * Note 1::
 * 
 * We can use just @Component instead of specifying a custom bean ID in (""),
 * In this case the Spring will use the Default bean ID - which will be the class name but
 * 		the first letter of the class name will be lower cased and used.
 * Example in above class, if we use
 * @Component
 * public class TennisCoach implements COach{
 * 
 * }
 * 
 * here the spring will use the bean ID as 'tennisCoach',
 * and thus in the Annotation_DemoApp class we will have to use the "tennisCoach" as a bean name
 * instead of "thatSillyCoach"
 * 
 * */

/*
 * Note 2::
 * 
 * We can comment the @Autowired annotation and still the code will work - why ?
 * -> As of Spring Framework 4.3, 
 * an @Autowired annotation on such a constructor is no longer necessary if the target bean only 
 * defines one constructor to begin with. 
 * However, if several constructors are available, at least one must be annotated to teach the 
 * container which one to use.
 * I personally prefer to use the @Autowired annotation because it makes the code more readable. 
 * But as mentioned, the @Autowired is not required for this scenario.
 */
/*
 * Annotations - Default Bean Names ... and the Special Case
 * In general, when using Annotations, for the default bean name, Spring uses the following rule.
 * If the annotation's value doesn't indicate a bean name, an appropriate name will be built based on the short name of the class (with the first letter lower-cased).
 * For example:		
 * HappyFortuneService --> happyFortuneService
 * ---
 * However, for the special case of when BOTH the first and second characters of the class name 
 * are upper case, then the name is NOT converted.
 * 
 * For the case of RESTFortuneService
 * RESTFortuneService --> RESTFortuneService
 * 		No conversion since the first two characters are upper case.
 * Behind the scenes, Spring uses the Java Beans Introspector to generate the default bean name. 
 * 
 */

/*
 * Note 3::
 * @Qualifier is a nice feature, but it is tricky when used with Constructors.
 * The syntax is much different from other examples and not exactly intuitive.  
 * Consider this the "deep end of the pool" when it comes to Spring configuration LOL :-)
 * 	You have to place the @Qualifier annotation inside of the constructor arguments. 
 * 
 * Here's an example from our classroom example. 
 * I updated it to make use of constructor injection, with @Autowired and @Qualifier. 
 * 
 *     @Autowired
 *     public TennisCoach(@Qualifier("randomFortuneService") FortuneService theFortuneService) {
 *     		System.out.println(">> TennisCoach: inside constructor using @autowired and @qualifier");
 *     		fortuneService = theFortuneService;
 *     }
 *     
 */

/*
 * Note 4 :: @PostConstruct & @PreDestroy Java9 and ahead fix
 * Solution :
 * 	
 * 	1. Download the javax.annotation-api-1.3.2.jar from 
 * https://search.maven.org/remotecontent?filepath=javax/annotation/javax.annotation-api/1.3.2/javax.annotation-api-1.3.2.jar
 * 	
 * 	2. Copy the JAR file to the lib folder of your project
 * ---
 * Use the following steps to add it to your Java Build Path.
 * 
 * 	3. Right-click your project, select Properties
 * 
 * 	4. On left-hand side, click Java Build Path
 * 
 * 	5. In top-center of dialog, click Libraries
 * 
 * 	6. Click Classpath and then Click Add JARs ...
 * 
 * 	7. Navigate to the JAR file <your-project>/lib/javax.annotation-api-1.3.2.jar
 * 
 * 	8. Click OK then click Apply and Close
 * 
 * Eclipse will perform a rebuild of your project and it will resolve the related build errors.
 * 
 */

/*
 * Special Note about Destroy Lifecycle and Prototype Scope
 * Here is a subtle point you need to be aware of with "prototype" scoped beans.
 * For "prototype" scoped beans, Spring does not call the @PreDestroy method.  Gasp!  
 * I didn't know this either until I dug through the Spring reference manual researching 
 * a student's question.
 * 
 * Here is the answer from the Spring reference manual. Section 1.5.2
 * https://docs.spring.io/spring/docs/current/spring-framework-reference/core.html#beans-factory-scopes-prototype
 * ---         
 * 
 * In contrast to the other scopes, Spring does not manage the complete lifecycle of a
 * prototype bean: the container instantiates, configures, and otherwise assembles a
 * prototype object, and hands it to the client, with no further record of that prototype instance.
 * 
 * Thus, although initialization lifecycle callback methods are called on all objects regardless 
 * of scope, in the case of prototypes, configured destruction lifecycle callbacks are not called. 
 * The client code must clean up prototype-scoped objects and release expensive resources that the 
 * prototype bean(s) are holding. 
 * To get the Spring container to release resources held by prototype-scoped beans, 
 * try using a custom bean post-processor, which holds a reference to beans that need to 
 * be cleaned up.
 * 
 * ---
 * 
 * This also applies to XML configuration.
 * 
 * ---
 * 
 * QUESTION: How can I create code to call the destroy method on prototype scope beans
 * 
 * ANSWER:
 * You can destroy prototype beans but custom coding is required. This examples shows how 
 * to destroy prototype scoped beans.
 * 
 * 1. Create a custom bean processor. This bean processor will keep track of prototype scoped 
 * beans. During shutdown it will call the destroy() method on the prototype scoped beans.
 * 
 * 2. The prototype scoped beans MUST implement the DisposableBean interface. This interface 
 * defines a "destroy()" method. This method should be used instead of the @PreDestroy annotation.
 * 
 * 3. In this app, BeanProcessorDemoApp.java is the main program. TennisCoach.java is the 
 * prototype scoped bean. TennisCoach implements the DisposableBean interface and provides the 
 * destroy() method. The custom bean processing is handled in the MyCustomBeanProcessor class.
 * 
 * See source code here for details: destroy-protoscope-bean-with-custom-processor.zip
 */
 