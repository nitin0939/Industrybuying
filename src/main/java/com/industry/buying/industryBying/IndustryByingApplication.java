package com.industry.buying.industryBying;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.industry.buying.industryBying.config","com.industry.buying.industryBying.constants", "com.industry.buying.industryBying.controller", "com.industry.buying.industryBying.model",
	"com.industry.buying.industryBying.repository","com.industry.buying.industryBying.service","com.industry.buying.industryBying.serviceimpl","com.industry.buying.industryBying","com.industry.buying.industryBying.response",
	"com.industry.buying.industryBying.Enum"})
@SpringBootApplication
@EntityScan("com.industry.buying.industryBying.model")
public class IndustryByingApplication {

	public static void main(String[] args) {
		SpringApplication.run(IndustryByingApplication.class, args);
	}

}
