package com.app;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class DemoApplication {

	
//	@Autowired
//	private PasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean // equivalent to <bean id ..../> in xml file
	public ModelMapper configureMapper() {
		System.out.println("in config mapper....");
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper;//method rets bean instance to SC
	}
	
//	@Bean
//	public WebMvcConfigurer confiure() {
//		return new WebMvcConfigurer() {
//			public void addCorsMapping(CorsRegistry reg) {
//				reg.addMapping("/**").allowedOrigins("*");
//			}
//		
//		};
//		
//	}
	
	


	
	

}
