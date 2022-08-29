package com.atguigu.ggkt.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {

	
	@Bean
	public Docket webApiConfig() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				  .groupName("ggkt")
				  .apiInfo(webApiInfo())
				  .select()
				  .build();
	}
	
	public ApiInfo webApiInfo() {
		
		return new ApiInfoBuilder()
				  .title("")
				  .description(null)
				  .version(null)
				  .contact(new Contact("atguigu", "http://atguigu.com", "atguigu.com"))
				  .build();
	}
}
