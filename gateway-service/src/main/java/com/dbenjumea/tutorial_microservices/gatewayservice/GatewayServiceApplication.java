package com.dbenjumea.tutorial_microservices.gatewayservice;

import com.dbenjumea.tutorial_microservices.gatewayservice.filters.pre.SimpleFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringBootApplication
public class GatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceApplication.class, args);
	}

	@Bean
	public SimpleFilter simpleFilter()
	{
		return new SimpleFilter();
	}
}
