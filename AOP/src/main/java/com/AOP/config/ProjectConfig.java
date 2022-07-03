package com.AOP.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration()
@ComponentScan(basePackages = "com.AOP.beans")
@EnableAspectJAutoProxy
public class ProjectConfig {
    // Placeholder Class.
}
