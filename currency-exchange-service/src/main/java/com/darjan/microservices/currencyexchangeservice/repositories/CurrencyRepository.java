package com.darjan.microservices.currencyexchangeservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.darjan.microservices.currencyexchangeservice.models.Currency;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {

	List<Currency> findAllByAbbreviationIgnoreCaseContaining(String string);

	Currency findByAbbreviationIgnoreCase(String abbr);

}
