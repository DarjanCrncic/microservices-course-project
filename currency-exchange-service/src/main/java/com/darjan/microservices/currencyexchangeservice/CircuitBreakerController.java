package com.darjan.microservices.currencyexchangeservice;

import javax.swing.Spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {

	private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);
	
	@GetMapping("/sample-api")
	@Retry(name = "default", fallbackMethod="fallbackMethod")
	public String sampleApi() {
		logger.info("Sample API call received");
		new RestTemplate().getForEntity("http://localhost:8080/some-uri", Spring.class);
		return "Sample API";
	}
	
	public String fallbackMethod (Exception ex) {
		return "Fallback response";
	}
}
