package com.darjan.microservices.currencyexchangeservice.models;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CurrencyExchange {
	
	private Long from;

	private Long to;
	
	private BigDecimal conversionMultiple;
	
	private String environment;
	
	public CurrencyExchange(Long from, Long to, BigDecimal conversionMultiple) {
		super();
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
	}
	
	
}
