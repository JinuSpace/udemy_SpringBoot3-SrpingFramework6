package com.in28minutes.learnspringframework.examples.a1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
@Component
class YourBusinessClass{
	
	Depencency1 depencency1;
	
	Depencency2 depencency2;
	
	
	//@Autowired
public YourBusinessClass(Depencency1 depencency1, Depencency2 depencency2) {
		super();
		System.out.println("Constructor Injection - YourBusinessClass");
		this.depencency1 = depencency1;
		this.depencency2 = depencency2;
	}



//	public Depencency1 getDepencency1() {
//		return depencency1;
//	}
//
//
//	@Autowired
//	public void setDepencency1(Depencency1 depencency1) {
//		System.out.println("Setter Injection - setDepencency1");
//		this.depencency1 = depencency1;
//	}
//
//
//
//	public Depencency2 getDepencency2() {
//		return depencency2;
//	}
//
//
//	@Autowired
//	public void setDepencency2(Depencency2 depencency2) {
//		System.out.println("Setter Injection - setDepencency2");
//		this.depencency2 = depencency2;
//	}



	public String toString() {
		return "Using " + depencency1 + " and " + depencency2;
	}
	
}
@Component
class Depencency1{
	
}
@Component
class Depencency2{
	
}

@Configuration
@ComponentScan
public class DepInjectionLauncherApplication {

	
	
	
	public static void main(String[] args) {
		
		try(var context = 
				new AnnotationConfigApplicationContext
					(DepInjectionLauncherApplication.class)){

			Arrays.stream(context.getBeanDefinitionNames())
				.forEach(System.out::println);
			System.out.println(context.getBean(YourBusinessClass.class));
			
		}
	}
}
