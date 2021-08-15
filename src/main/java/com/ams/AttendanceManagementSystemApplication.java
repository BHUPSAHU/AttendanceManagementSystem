package com.ams;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class AttendanceManagementSystemApplication {
	
	private final static Logger LOGGER = LogManager.getLogger(AttendanceManagementSystemApplication.class);
	
	public static void main(String[] args){
		SpringApplication.run(AttendanceManagementSystemApplication.class, args);
		LOGGER.info("\n~~~~~~~~~~~~~~~~~~~~~\nCONNECTED TO DB\n~~~~~~~~~~~~~~~~~~~~~");
		}
	
	@Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2).select()
            .apis(RequestHandlerSelectors.basePackage("com")).build();
     }
	
}
