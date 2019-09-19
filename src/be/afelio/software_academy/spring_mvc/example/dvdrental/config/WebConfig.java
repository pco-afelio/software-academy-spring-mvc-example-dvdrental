package be.afelio.software_academy.spring_mvc.example.dvdrental.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan("be.afelio.software_academy.spring_mvc.example.dvdrental.controller")
public class WebConfig {

}
