package com.LearningSpring.SchoolProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
	For excluding any class from automatically generating beans by the Spring framework. We can use the "exclude list"
	to remove such classes.

	@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, DataSourceProperties.class })
	in such format.

	@SpringBootApplication annotation is made up of several inner annotations.
		-- @SpringBootConfiguration : It is same as @Configuration annotation in the earlier projects.
		-- @SpringAutoConfiguration : This annotation is responsible for autoconfiguring all the required files in our
									  System & which are defined in the application.properties file.
		-- @ComponentScan			: This annotation is required for the Spring framework to determine where to look
		   							  for classes to create beans.
		-- etc.
 */

@SpringBootApplication
public class SchoolProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolProjectApplication.class, args);
	}

}
