package com.darjan.microservices.limitsservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.darjan.microservices.limitsservice.configuration.Configuration;
import com.darjan.microservices.limitsservice.model.Limits;

@RestController
public class LimitsController {
	
	private Configuration configuration;
	
	public LimitsController(Configuration configuration) {
		super();
		this.configuration = configuration;
	}



	@GetMapping("/limits")
	public Limits retrieveLimits() {
		return new Limits(configuration.getMinimum(), configuration.getMaximum());
	}
	
}
