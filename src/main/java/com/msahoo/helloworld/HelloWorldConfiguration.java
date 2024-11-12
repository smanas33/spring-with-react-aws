package com.msahoo.helloworld;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

record Person(String name, int age) {};

@Configuration
public class HelloWorldConfiguration {
	@Bean
	public String name() {
		return "Manas";
	}
	
	@Bean
	public int age() {
		return 15;
	}
	
	@Bean
	public Person person() {
		return new Person("Manas", 30);
	}
}
