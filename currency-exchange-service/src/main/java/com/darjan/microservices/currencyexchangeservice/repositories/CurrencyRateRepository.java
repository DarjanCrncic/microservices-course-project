package com.darjan.microservices.currencyexchangeservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.darjan.microservices.currencyexchangeservice.models.CurrencyRate;

public interface CurrencyRateRepository extends JpaRepository<CurrencyRate, Long> {

	CurrencyRate findByFromIdAndToId(Long from, Long to);

}
