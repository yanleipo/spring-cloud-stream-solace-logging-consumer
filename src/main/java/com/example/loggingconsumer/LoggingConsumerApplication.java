package com.example.loggingconsumer;

import java.util.function.Function;
import java.util.function.Consumer;
import java.util.function.Supplier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LoggingConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoggingConsumerApplication.class, args);
	}

	/*
    @Bean
	public Function<String, String> uppercase() {
	    return value -> {
	        System.out.println("Received: " + value);
	        return value.toUpperCase();
	    };
	}
    */
	
	@Bean
	public Supplier<String> source() {
		return () -> "Solace SCS test message!";
	}
	
	@Bean
	public Consumer<String> sink() {
		return System.out::println;
	}
}
