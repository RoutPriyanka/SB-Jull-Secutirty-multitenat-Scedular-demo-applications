package com.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan("com.task.*")

public class MultitenantSchedulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultitenantSchedulerApplication.class, args);
	}

}
