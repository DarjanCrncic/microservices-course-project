package com.darjan.microservices.currencyexchangeservice;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.darjan.microservices.currencyexchangeservice.models.Currency;
import com.darjan.microservices.currencyexchangeservice.models.CurrencyExchange;
import com.darjan.microservices.currencyexchangeservice.models.CurrencyRate;
import com.darjan.microservices.currencyexchangeservice.repositories.CurrencyRateRepository;
import com.darjan.microservices.currencyexchangeservice.repositories.CurrencyRepository;

@RestController
@RequestMapping("/currency-exchange")
public class CurrencyExchangeController {
	
	private Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);
	
	private Environment environment;

	private CurrencyRepository currencyRepository;
	private CurrencyRateRepository currencyRateRepository;
	
	public CurrencyExchangeController(Environment environment, CurrencyRepository currencyRepository, CurrencyRateRepository currencyRateRepository) {
		super();
		this.environment = environment;
		this.currencyRepository = currencyRepository;
		this.currencyRateRepository = currencyRateRepository;
	}

	@GetMapping("/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValue(@PathVariable Long from, @PathVariable Long to) {
		
		logger.info("retrieveExchangeValue called with {} to {}", from, to);
		
		CurrencyRate currencyRate = currencyRateRepository.findByFromIdAndToId(from, to);
		
		if(currencyRate == null) {
			throw new RuntimeException("Unable to find data for " + from + " to " + to);
		}
		
		CurrencyExchange currencyExchange = new CurrencyExchange(from, to, currencyRate.getConversionMultiple());	
		currencyExchange.setEnvironment(environment.getProperty("local.server.port"));
		return currencyExchange;
	}
		
	@GetMapping("/currencies")
	public List<Currency> getAllCurrencies(@RequestParam Optional<String> q) {
		if (q.isPresent()) return currencyRepository.findAllByAbbreviationIgnoreCaseContaining(q.get());
		return currencyRepository.findAll();
	}
	
	@GetMapping("/conversion-rate/from/{from}/to/{to}")
	public CurrencyRate getCurrencyRate(@PathVariable Long from, @PathVariable Long to) {
		return currencyRateRepository.findByFromIdAndToId(from, to);
	}
	
	@GetMapping("/currencies/{abbr}")
	public Long getCurrencyId(@PathVariable String abbr) {
		return currencyRepository.findByAbbreviationIgnoreCase(abbr).getId();
	}
}
