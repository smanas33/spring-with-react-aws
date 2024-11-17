package com.msahoo.springbootaws.learn01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String name() {
        return "Manas";
    }

    @Bean
    public int age() {
        return 25;
    }

    @Bean
    public Person person() {
        return new Person("Virat Kohli", 35, new Address("Main Street", "Delhi"));
    }

    @Bean
    public Person person2MethodCall() {
        return new Person(name(), age(), address());
    }

    @Bean
    public Person person3Parameters(String name, int age, Address address) {
        return new Person(name, age, address);
    }

    @Bean(name = "address2")
    public Address address() {
        return new Address("Kalpana Street", "Bhubaneswar");
    }
}

record Person(String name, int age, Address address) {};

record Address(String firstLine, String city) {};
