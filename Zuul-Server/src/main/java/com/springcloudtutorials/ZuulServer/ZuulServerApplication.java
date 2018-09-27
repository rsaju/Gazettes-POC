package com.springcloudtutorials.ZuulServer;

import com.springcloudtutorials.ZuulServer.ZuulFilters.TestZuulFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
@Configuration
public class ZuulServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulServerApplication.class, args);
	}

	@Bean
	public TestZuulFilter testZuulFilter(){
		return new TestZuulFilter();
	}
}
